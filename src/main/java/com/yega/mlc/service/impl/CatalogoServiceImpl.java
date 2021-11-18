package com.yega.mlc.service.impl;


import com.yega.mlc.dto.EstadoDto;
import com.yega.mlc.dto.PaisDto;
import com.yega.mlc.entity.Cestados;
import com.yega.mlc.entity.Cpais;
import com.yega.mlc.repository.CatEstadoRepository;
import com.yega.mlc.repository.CatPaisRepository;
import com.yega.mlc.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogoServiceImpl implements CatalogoService {

    @Autowired
    CatPaisRepository catPaisRepository;

    @Autowired
    CatEstadoRepository catEstadoRepository;

    @Override
    public List getCatPaises() {

        List<Cpais> list = catPaisRepository.findAll();
        PaisDto paisDto = null;
        List listPaisDto = new ArrayList<PaisDto>();

        for(Cpais pais : list){
            paisDto = new PaisDto();
            paisDto.setPaisid(pais.getPaisid());
            paisDto.setClavepais(pais.getClavepais());
            paisDto.setDescripcionpais(pais.getDescripcionpais());
            paisDto.setActivo(pais.getActivo());

            listPaisDto.add(paisDto);
        }
        return listPaisDto;
    }

    @Override
    public List getCatEstados(short idPais) {

        List<Cestados> list = catEstadoRepository.findByPaisid(new Cpais(idPais));

        EstadoDto estadoDto = null;
        List listPaisDto = new ArrayList<EstadoDto>();

        for(Cestados estado : list){
            estadoDto = new EstadoDto();
            estadoDto.setEstadoid(estado.getEstadoid());
            estadoDto.setClaveestado (estado.getClaveestado());
            estadoDto.setNombreestado (estado.getNombreestado());
            estadoDto.setActivo(estado.getActivo());

            listPaisDto.add(estadoDto);
        }
        return listPaisDto;
    }

}
