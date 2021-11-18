package com.yega.mlc.controller;

import com.yega.mlc.dto.AceptarPropuestaDTO;
import com.yega.mlc.dto.GetPropuestaResponseDTO;
import com.yega.mlc.dto.PropBeneficiarioBeneficioDTO;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface PropuestaController {

    ResponseEntity<GetPropuestaResponseDTO> getPropuestaByCurp(Map<String, String> headers, String curp);
    
    ResponseEntity<PropBeneficiarioBeneficioDTO> getResumenPropuesta(Map<String, String> headers, String curp);

    ResponseEntity<Object> aceptarPropuesta (Map<String, String> headers, AceptarPropuestaDTO aceptarPropuesta);

    ResponseEntity<Object> propuestaById (Map<String, String> headers, Integer propuestaId);

    ResponseEntity<Object> propuestaAllDataById (Map<String, String> headers, Integer propuestaId);
}
