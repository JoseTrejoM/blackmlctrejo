package com.yega.mlc.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.yega.mlc.dto.BeneficiarioDTO;
import com.yega.mlc.dto.ErrorCodeDTO;
import com.yega.mlc.dto.FieldQueryDTO;
import com.yega.mlc.entity.BeneficiarioEntity;
import com.yega.mlc.exception.ServiceException;
import com.yega.mlc.exception.utils.UtilsEx;
import com.yega.mlc.repository.BeneficiaryRepository;
import com.yega.mlc.service.BeneficiaryService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {
    private static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private BeneficiaryRepository beneficiaryRepository;

    @Override
    public BeneficiarioDTO crear(BeneficiarioDTO beneficiario) throws ServiceException {
        try {
            var beneficiarioEntity = modelMapper.map(beneficiario, BeneficiarioEntity.class);
            return modelMapper.map(beneficiaryRepository.save(beneficiarioEntity), BeneficiarioDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public List<BeneficiarioDTO> createBeneficiary(List<BeneficiarioDTO> beneficiarios) throws ServiceException {
        try {
            var listBenEntity = beneficiarios.stream()
                    .map(element -> modelMapper.map(element, BeneficiarioEntity.class)).collect(Collectors.toList());
            var listSave = beneficiaryRepository.saveAll(listBenEntity);
            return listSave.stream().map(element -> modelMapper.map(element, BeneficiarioDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public BeneficiarioDTO eliminar(Integer beneficiarioId) throws ServiceException {
        var beneficiario = getById(beneficiarioId);
        try {
            beneficiaryRepository.deleteById(beneficiarioId);
            return beneficiario;
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
        
    }

    @Override
    public void deleteByIds(List<Integer> beneficiarioIds) throws ServiceException {
        try {
            beneficiaryRepository.deleteAllById(beneficiarioIds);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
        
    }

    @Override
    public List<BeneficiarioDTO> getResultSet(Set<FieldQueryDTO> fields) throws ServiceException {
        try {
            var listResulSet = beneficiaryRepository.getResultSet(fields, BeneficiarioEntity.class);
            return listResulSet.stream().map(element -> modelMapper.map(element, BeneficiarioDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public BeneficiarioDTO getById(Integer beneficiarioId) throws ServiceException {
        try {
            var opEntity = beneficiaryRepository.findById(beneficiarioId);
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_FOUND, String.format("Beneficiary not found with id %d", beneficiarioId));            
            var entity = opEntity.orElseThrow(() -> new ServiceException(errorCode, errorCode.getMessage()));
            return modelMapper.map(entity, BeneficiarioDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public List<BeneficiarioDTO> getAll() throws ServiceException {
        try {
            var list = beneficiaryRepository.findAll();
            list.sort((a, b) -> a.getBeneficiarioId().compareTo(b.getBeneficiarioId()));
            return list.stream().map(element -> modelMapper.map(element, BeneficiarioDTO.class)).collect(Collectors.toList());            
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public BeneficiarioDTO actualizar(BeneficiarioDTO beneficiario) throws ServiceException {
        getById(beneficiario.getBeneficiarioId());
        try {
            return crear(beneficiario);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

}
