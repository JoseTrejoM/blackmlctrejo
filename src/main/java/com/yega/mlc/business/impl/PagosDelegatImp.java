/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.business.impl;

import com.yega.mlc.business.PagosDelegate;
import com.yega.mlc.common.Correo;
import com.yega.mlc.constants.BusinessConstants;
import com.yega.mlc.dto.BeneficiosBeneficiariosDTO;
import com.yega.mlc.dto.ContactoPersonaDTO;
import com.yega.mlc.dto.ErrorCodeDTO;
import com.yega.mlc.dto.GetPropuestaResponseDTO;
import com.yega.mlc.dto.MembresiaDTO;
import com.yega.mlc.dto.PersonaMailDTO;
import com.yega.mlc.dto.PersonaResDTO;
import com.yega.mlc.dto.UsuarioDTO;
import com.yega.mlc.dto.pagos.PaymentIntentDTO;
import com.yega.mlc.dto.pagos.TokenDTO;
import com.yega.mlc.entity.ConfiguracionSysEntity;
import com.yega.mlc.entity.MembresiaEntity;
import com.yega.mlc.entity.PagosEntity;
import com.yega.mlc.entity.PeriodoVigenciaEntity;
import com.yega.mlc.exception.ServiceException;
import com.yega.mlc.repository.ConfiguracionSysRepository;
import com.yega.mlc.repository.MembresiaRespository;
import com.yega.mlc.repository.PagosRepository;
import com.yega.mlc.repository.PeriodoVigenciaRepository;
import com.yega.mlc.service.ContactoPersonaService;
import com.yega.mlc.service.PersonaFisicaService;
import com.yega.mlc.service.PersonaService;
import com.yega.mlc.service.impl.PropuestaServiceWebImpl;
import com.yega.mlc.service.impl.UserServiceImpl;
import com.yega.mlc.utils.DateUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 *
 * @author OSCAR
 */
@Component("pagosDelegate")
public class PagosDelegatImp implements PagosDelegate {

    @Autowired
    private MembresiaRespository membresiaRepository;
    @Autowired
    private ConfiguracionSysRepository configuracionRepository;
    @Autowired
    private PropuestaServiceWebImpl propuestaService;
    @Autowired
    private PeriodoVigenciaRepository periodoVigenciaRepository;
    @Autowired
    private UserServiceImpl usuarioService;
    @Autowired
    private PersonaFisicaService personaFisicaService;
    @Autowired
    private PersonaService personaService;
    @Autowired
    private PagosRepository pagoRepository;
     @Autowired
    private Correo correo;

    @Autowired
    private ContactoPersonaService contactoPersonaService;
    synchronized public boolean crearTransaccionPago(TokenDTO tokenDTO, PaymentIntentDTO paymentIntent) {
        int propuestaId = tokenDTO.getPropuestaid();
        boolean correcto=false;
        GetPropuestaResponseDTO propuesta = propuestaService.getPropuestaByCurp(tokenDTO.getCurp());
        
        // Obtener la propuesta y ServicioContratado ok
        MembresiaEntity membresia = generaMembresia(propuestaId);
        if (membresia != null) { //  Genera Periodo de vigencia ok
            paymentIntent.setMembresia(membresia.getNumMembresia() + (membresia.getConsecutivo()>0? "-" + membresia.getConsecutivo():""));
            PeriodoVigenciaEntity periodoVigencia = guardaPeriodoVigencia(propuesta.getPlan().getServicioContratadoId());
            paymentIntent.setTraza(paymentIntent.getTraza() + "2.- Se generó la membresia <p>");
            if (periodoVigencia != null) {
                paymentIntent.setTraza(paymentIntent.getTraza() + "3.- Se generó la vigencia <p>");
                String strDateFormat = "dd/MM/yyyy"; // El formato de fecha está especificado  
               SimpleDateFormat dateFormat = new SimpleDateFormat(strDateFormat);
                paymentIntent.setFechaInicioVigencia(dateFormat.format(periodoVigencia.getFechaInicio()));
                paymentIntent.setFechaFinVigencia(dateFormat.format(periodoVigencia.getFechaFin()));
                PagosEntity pagos = guardaPagos(tokenDTO, periodoVigencia, membresia);
                if (pagos != null) {
                    // generar usuario
                    paymentIntent.setTraza(paymentIntent.getTraza() + "4.- Se registro su pago <p>");
                    int personaId = getTitularId(propuesta.getBeneficios().get(0).getBeneficiosbeneficiarios());
                    
                    PersonaResDTO personaResDTO = getById(personaId);
                    UsuarioDTO usuarioDTO = usuarioService.crearUsuario(personaResDTO);
                    if (usuarioDTO != null) {
                        paymentIntent.setTraza(paymentIntent.getTraza() + "5.- Se envió el correo con su usuario <p>");
                        PersonaMailDTO personaCorreoDTO =  new PersonaMailDTO();
                        personaCorreoDTO.setPersona(personaResDTO.getPersonaFisica());
                          MembresiaDTO mem =  new MembresiaDTO(membresia.getEstatusMembresiaId(),
                                membresia.getEstatusMembresiaId(),
                                membresia.getNumMembresia(),membresia.getConsecutivo(),
                                membresia.getFechaAlta(),membresia.getUsuarioAlta(),membresia.getFechaModificacion(),
                                membresia.getUsuarioModificacion(), membresia.getActivo());
                        
                        personaCorreoDTO.setMembresia(mem);
                        personaCorreoDTO.setPago(tokenDTO.getPaymentIntent());
                        
                        ContactoPersonaDTO contacto = new ContactoPersonaDTO();
                        contacto.setContacto(usuarioDTO.getUsuario());
                        personaCorreoDTO.setContacto(contacto);
                        correo.envia(personaCorreoDTO,BusinessConstants.Correos.USUARIO);
                        correo.envia(personaCorreoDTO,BusinessConstants.Correos.CONTRATACION);
                        System.out.println("Enviando correo");
                        correcto= true;
                    }
                }
            }
        }

        return correcto;
    }

    public PagosEntity guardaPagos(TokenDTO tokenDTO, PeriodoVigenciaEntity periodoVigencia, MembresiaEntity membresia) {
        // Crear la transacion de pago realizada
        PagosEntity pagos = new PagosEntity();
        pagos.setFormaPagoId(20);
        pagos.setMonedaPagoId(tokenDTO.getPaymentIntent().getMoneda().getValue());
        pagos.setMembresiaId(membresia.getMembresiaId());
        pagos.setFechaPago(periodoVigencia.getFechaInicio());
        pagos.setMontoPago((double) tokenDTO.getPaymentIntent().getMonto());
        pagos.setReferencia(tokenDTO.getPaymentIntent().getDescripcion());
        pagos.setTransaccion(tokenDTO.getPaymentIntent().getTransaccion());
        pagos.setVigenciaId(periodoVigencia.getPeriodoVigenciaId());
        pagos.setActivo(true);
        pagos.setFechaAlta(new Date());
        pagos.setUsuarioAlta(1);
        pagos = pagoRepository.save(pagos);
        return pagos;
    }

    public PeriodoVigenciaEntity guardaPeriodoVigencia(int servicioContratadoId) {
        Date fechaInicio = new Date();
        Date fechaFin = DateUtils.mesesTofecha(fechaInicio, 12);
        PeriodoVigenciaEntity periodoVigencia = new PeriodoVigenciaEntity();
        periodoVigencia.setServicioContratadoId(servicioContratadoId);
        periodoVigencia.setFechaInicio(fechaInicio);
        periodoVigencia.setFechaFin(fechaFin);
        periodoVigencia.setActivo(true);
        periodoVigencia.setFechaAlta(new Date());
        periodoVigencia.setUsuarioAlta(1);
        periodoVigencia = periodoVigenciaRepository.save(periodoVigencia);
        return periodoVigencia;
    }

   

    public int getTitularId(List<BeneficiosBeneficiariosDTO> listaBeneficiarios) {
        int personaId = 0;
        for (BeneficiosBeneficiariosDTO beneficiario : listaBeneficiarios) {
            if (beneficiario.getTipobeneficiario().equalsIgnoreCase("Titular")) {
                personaId = beneficiario.getPersonaid();
                break;
            }
        }
        return personaId;
    }

    public MembresiaEntity generaMembresia(Integer propuestaId) {
        List<MembresiaEntity> listaMembresia = membresiaRepository.findByPropuestaId(propuestaId);
        MembresiaEntity membresia = new MembresiaEntity();
        membresia.setActivo(true);
        membresia.setUsuarioAlta(1);
        membresia.setEstatusMembresiaId(6);
        membresia.setFechaAlta(new Date());
        membresia.setPropuestaId(propuestaId);
        String numeroMembresia = "";
        // Obtener la membresia si no tiene se genera la membresia ok 
        int actual =0;
        if (listaMembresia != null && listaMembresia.size() >= 1) {
            for (MembresiaEntity membresias : listaMembresia) {
                if (membresias.getActivo()) {
                    membresias.setActivo(Boolean.FALSE);
                    membresia.setEstatusMembresiaId(4);
                    membresias.setFechaModificacion(new Date());
                    membresias.setUsuarioModificacion(1);
                    membresiaRepository.save(membresias);

                }
                if (membresias.getConsecutivo() >= actual) {
                    numeroMembresia = membresias.getNumMembresia();
                    actual = membresias.getConsecutivo();
                }
            }

            membresia.setConsecutivo(actual + 1);
              membresia.setNumMembresia(numeroMembresia);
            membresia = membresiaRepository.save(membresia);

        } else {
            Optional<ConfiguracionSysEntity> configMembresia = configuracionRepository.findByNombre("ConsecutivoMembresia");  //Nombre("consecutivoMembresia");
            int numMembresia = Integer.parseInt(configMembresia.get().getValor());
            membresia.setNumMembresia(String.format("%09d", numMembresia));
            numMembresia++;
            configMembresia.get().setValor(String.valueOf(numMembresia));
            configuracionRepository.save(configMembresia.get());
            membresia.setConsecutivo(0);
            membresia = membresiaRepository.save(membresia);

        }
        return membresia;
    }

    public PersonaResDTO getById(Integer personaId) throws ServiceException {
        try {
            var persona = personaService.getById(personaId);
            var personaFis = personaFisicaService.getById(personaId);
            var listContacto = contactoPersonaService.getAllByPersonaId(personaId);
            return new PersonaResDTO(persona, personaFis, null, listContacto);
        } catch (Exception e) {
            var message = String.format("Cann't get person by id %d , %s", personaId, e.toString());
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_ACCEPTABLE, message);
            throw new ServiceException(errorCode, errorCode.getMessage());
        }
    }
}
