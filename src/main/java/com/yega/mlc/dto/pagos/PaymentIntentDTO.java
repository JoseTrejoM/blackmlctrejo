package com.yega.mlc.dto.pagos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yega.mlc.constants.EnumMoneda;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentIntentDTO {

    private String descripcion;
    private int monto;
    private EnumMoneda moneda;
    private String transaccion;
    private String estatustransaccion;
    private String traza;
    private String fechaInicioVigencia;
    private String fechaFinVigencia;
    private String membresia;
   
}
