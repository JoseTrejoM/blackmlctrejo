/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.dto.pagos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
/**
 *
 * @author OSCAR
 */
public class TokenDTO {

    int propuestaid;
    String curp;
    //[[Prototype]]; Object
    String client_ip; //"187.190.189.61"
    Integer created; //1632879878
    String id; //"tok_1JerqcLm93TetmkaRz6VSCpt"
    Boolean livemode; //false
    String object; //"token"
    String type; //"card"
    Boolean used; //false
    Integer monto; // Monto a pagar
    CardDTO card;   //Datos de la tarjeta
    PaymentIntentDTO paymentIntent;   // Intentcion de pago    
}
