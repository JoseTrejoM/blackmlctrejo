package com.yega.mlc.controller.impl;

import com.yega.mlc.business.RegisterDelegate;
import com.yega.mlc.controller.PropuestaController;
import com.yega.mlc.dto.AceptarPropuestaDTO;
import com.yega.mlc.dto.GetPropuestaResponseDTO;
import com.yega.mlc.dto.PropBeneficiarioBeneficioDTO;
import com.yega.mlc.service.ProposalService;
import com.yega.mlc.service.PropuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class PropuestaControllerImpl implements PropuestaController {

    @Autowired
    @Qualifier("propuestaServiceWeb")
    private PropuestaService propuestaService;

    @Autowired
    @Qualifier("registerDelegateCore")
    private RegisterDelegate registerDelegate;

    @Autowired
    private ProposalService proposalService;

    @Override
    @GetMapping("/getPropuesta/{curp}")
    public ResponseEntity<GetPropuestaResponseDTO> getPropuestaByCurp(Map<String, String> headers, @PathVariable("curp")  String curp) {

        GetPropuestaResponseDTO propuesta =  propuestaService.getPropuestaByCurp(curp);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(propuesta);
    }

    @Override
    @GetMapping("/getResumenPropuesta/{curp}")
    public ResponseEntity<PropBeneficiarioBeneficioDTO> getResumenPropuesta(Map<String, String> headers, @PathVariable("curp")  String curp) {
        PropBeneficiarioBeneficioDTO propuesta =  propuestaService.getResumenPropuesta(curp);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(propuesta);
    }

    @Override
    @PostMapping("/propuesta/aceptar")
    public ResponseEntity<Object> aceptarPropuesta(@RequestHeader Map<String, String> headers, @RequestBody AceptarPropuestaDTO aceptarPropuesta) {
        var propAceptada =  registerDelegate.acceptProposal(aceptarPropuesta);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(propAceptada);
    }

    @Override
    @GetMapping("/propuesta/byid/{propuestaId}")
    public ResponseEntity<Object> propuestaById(@RequestHeader Map<String, String> headers, @PathVariable Integer propuestaId) {
        var propuesta =  proposalService.getById(propuestaId);
        return ResponseEntity.status(HttpStatus.OK).body(propuesta);
    }

    @Override
    @GetMapping("/propuesta/alldatabyid/{propuestaId}")
    public ResponseEntity<Object> propuestaAllDataById(@RequestHeader Map<String, String> headers, @PathVariable Integer propuestaId) {
        var propuesta =  proposalService.getAllDataById(propuestaId);
        return ResponseEntity.status(HttpStatus.OK).body(propuesta);
    }
}
