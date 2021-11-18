package com.yega.mlc.service.impl;

import com.yega.mlc.dto.BeneficiosBeneficiariosResponseDTO;
import com.yega.mlc.entity.Cbeneficios;
import com.yega.mlc.exception.utils.UtilsEx;
import com.yega.mlc.repository.BeneficiosBeneficiariosRepository;
import com.yega.mlc.repository.BeneficiosRepository;
import com.yega.mlc.service.BeneficiosServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeneficiosServicesImpl implements BeneficiosServices
{
    private static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private BeneficiosRepository beneficiosRepository;

    @Autowired
    private BeneficiosBeneficiariosRepository beneficiosBeneficiariosRepository;

    @Override
    public List getBeneficios() {
        try {
            var list = beneficiosRepository.findAll();
            modelMapper.typeMap(Cbeneficios.class, BeneficiosBeneficiariosResponseDTO.class)
                    .addMapping(src -> src.getRbeneficiosbeneficiarioCollection(), BeneficiosBeneficiariosResponseDTO::setBeneficiosbeneficiarios)
                    .addMapping(src -> src.getRserviciobeneficiarioCollection(), BeneficiosBeneficiariosResponseDTO::setServicios);
            return list.stream().map(b -> modelMapper.map(b, BeneficiosBeneficiariosResponseDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

//    @Override
//    public List<BeneficiosBeneficiariosDTO> getBeneficiosBeneficiarios() {
//        try {
//            var list = beneficiosBeneficiariosRepository.findAll();
//            return list.stream().map(b -> modelMapper.map(b, BeneficiosBeneficiariosDTO.class)).collect(Collectors.toList());
//        } catch (Exception e) {
//            UtilsEx.showStackTraceError(e);
//            throw UtilsEx.createServiceException(e);
//        }
//    }
}