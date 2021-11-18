/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yega.mlc.dto.pagos.PaymentIntentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author OSCAR
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class PersonaMailDTO {

    private PersonaFisicaDTO persona;
    private ContactoPersonaDTO contacto;
    private MembresiaDTO membresia;
    private PaymentIntentDTO pago;

    /**
     * @return the persona
     */
    public PersonaFisicaDTO getPersona() {
        return persona;
    }

    /**
     * @param persona the persona to set
     */
    public void setPersona(PersonaFisicaDTO persona) {
        this.persona = persona;
    }

    /**
     * @return the contacto
     */
    public ContactoPersonaDTO getContacto() {
        return contacto;
    }

    /**
     * @param contacto the contacto to set
     */
    public void setContacto(ContactoPersonaDTO contacto) {
        this.contacto = contacto;
    }

    /**
     * @return the membresia
     */
    public MembresiaDTO getMembresia() {
        return membresia;
    }

    /**
     * @param membresia the membresia to set
     */
    public void setMembresia(MembresiaDTO membresia) {
        this.membresia = membresia;
    }

    /**
     * @return the pago
     */
    public PaymentIntentDTO getPago() {
        return pago;
    }

    /**
     * @param pago the pago to set
     */
    public void setPago(PaymentIntentDTO pago) {
        this.pago = pago;
    }
    
}
