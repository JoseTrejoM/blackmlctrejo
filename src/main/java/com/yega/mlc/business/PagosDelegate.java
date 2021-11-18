/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.business;

import com.yega.mlc.dto.BeneficiosBeneficiariosDTO;
import com.yega.mlc.dto.PersonaResDTO;
import com.yega.mlc.dto.pagos.PaymentIntentDTO;
import com.yega.mlc.dto.pagos.TokenDTO;
import com.yega.mlc.entity.MembresiaEntity;
import com.yega.mlc.entity.PagosEntity;
import com.yega.mlc.entity.PeriodoVigenciaEntity;
import com.yega.mlc.exception.ServiceException;
import java.util.List;

/**
 *
 * @author OSCAR
 */
public interface PagosDelegate {

    public boolean crearTransaccionPago(TokenDTO tokenDTO, PaymentIntentDTO paymentIntent);

    public PagosEntity guardaPagos(TokenDTO tokenDTO, PeriodoVigenciaEntity periodoVigencia, MembresiaEntity membresia);

    public PeriodoVigenciaEntity guardaPeriodoVigencia(int servicioContratadoId);

    public int getTitularId(List<BeneficiosBeneficiariosDTO> listaBeneficiarios);

    public MembresiaEntity generaMembresia(Integer propuestaId);

    public PersonaResDTO getById(Integer personaId) throws ServiceException;
}
