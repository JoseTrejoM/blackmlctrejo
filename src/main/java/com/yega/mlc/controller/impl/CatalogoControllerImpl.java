package com.yega.mlc.controller.impl;

import com.yega.mlc.controller.CatalogoController;
import com.yega.mlc.dto.GetPropuestaResponseDTO;
import com.yega.mlc.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class CatalogoControllerImpl implements CatalogoController {

    @Autowired
    CatalogoService catalogoService;

    @Override
    @GetMapping("/getCatPais")
    public ResponseEntity<Object> getCatPaises(Map<String, String> headers) {
        List paises = catalogoService.getCatPaises();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(paises);
    }

    @Override
    @GetMapping("/getCatEstado/{idPais}")
    public ResponseEntity<Object> getCatEstados(Map<String, String> headers, @PathVariable("idPais")  short paisid) {
        List estados = catalogoService.getCatEstados(paisid);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(estados);
    }
}
