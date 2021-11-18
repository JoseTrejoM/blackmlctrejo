package com.yega.mlc.service;

import com.yega.mlc.dto.GetPropuestaResponseDTO;
import com.yega.mlc.dto.PropBeneficiarioBeneficioDTO;

public interface PropuestaService extends ServiceBase {
    GetPropuestaResponseDTO getPropuestaByCurp(String curp);
    PropBeneficiarioBeneficioDTO getResumenPropuesta(String curp);
}
