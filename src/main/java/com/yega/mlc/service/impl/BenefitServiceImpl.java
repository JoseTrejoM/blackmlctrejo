package com.yega.mlc.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.yega.mlc.dto.FieldQueryDTO;
import com.yega.mlc.dto.ServicioBeneficiarioDTO;
import com.yega.mlc.entity.ServicioBeneficiarioEntity;
import com.yega.mlc.exception.ServiceException;
import com.yega.mlc.exception.utils.UtilsEx;
import com.yega.mlc.repository.BenefitRepository;
import com.yega.mlc.service.BenefitService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("benefitServiceCore")
public class BenefitServiceImpl extends BenefitService {
    private static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private BenefitRepository benefitRepository;

    @Override
    public ServicioBeneficiarioDTO createBenefit(ServicioBeneficiarioDTO beneficio) throws ServiceException {
        try {
            var beneficioEntity = modelMapper.map(beneficio, ServicioBeneficiarioEntity.class);
            return modelMapper.map(benefitRepository.save(beneficioEntity), ServicioBeneficiarioDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public List<ServicioBeneficiarioDTO> createBenefit(List<ServicioBeneficiarioDTO> beneficios)
            throws ServiceException {
        try {
            var listBenEntity = beneficios.stream()
                    .map(element -> modelMapper.map(element, ServicioBeneficiarioEntity.class))
                    .collect(Collectors.toList());
            listBenEntity.forEach(element -> element.setActivo(1));
            var listSave = benefitRepository.saveAll(listBenEntity);
            return listSave.stream().map(element -> modelMapper.map(element, ServicioBeneficiarioDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public void deleteById(Integer beneficioId) throws ServiceException {
        try{
            benefitRepository.deleteById(beneficioId);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
        
    }

    @Override
    public void deleteByIds(List<Integer> beneficioIds) throws ServiceException {
        try{
            benefitRepository.deleteAllById(beneficioIds);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
        
    }

    @Override
    public List<ServicioBeneficiarioDTO> getResultSet(Set<FieldQueryDTO> fields) throws ServiceException {
        try{
            var listResultSet = benefitRepository.getResultSet(fields, ServicioBeneficiarioEntity.class);
            return listResultSet.stream().map(element -> modelMapper.map(element, ServicioBeneficiarioDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

}
