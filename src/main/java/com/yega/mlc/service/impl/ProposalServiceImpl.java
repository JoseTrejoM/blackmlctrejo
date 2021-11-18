package com.yega.mlc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.yega.mlc.dto.ErrorCodeDTO;
import com.yega.mlc.dto.FieldQueryDTO;
import com.yega.mlc.dto.PropuestaBeneficiariosDTO;
import com.yega.mlc.dto.PropuestaPersistDTO;
import com.yega.mlc.entity.PropuestaEntity;
import com.yega.mlc.exception.ServiceException;
import com.yega.mlc.exception.utils.UtilsEx;
import com.yega.mlc.repository.ProposalRepository;
import com.yega.mlc.repository.VBeneficiariosDePropuestaRepository;
import com.yega.mlc.service.ProposalService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class ProposalServiceImpl implements ProposalService {
    private static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private ProposalRepository proposalRepository;

    @Autowired
    private VBeneficiariosDePropuestaRepository vBeneficiariosDePropuestaRepository;

    @Override
    public PropuestaPersistDTO crear(PropuestaPersistDTO propuesta) throws ServiceException {
        try {
            var proposalEntity = modelMapper.map(propuesta, PropuestaEntity.class);
            return modelMapper.map(proposalRepository.save(proposalEntity), PropuestaPersistDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public PropuestaPersistDTO getById(Integer propuestaId) {
        try {
            var opProp = proposalRepository.findById(propuestaId);
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_FOUND,
                    String.format("Proposal not found with id %d", propuestaId));
            var propEntity = opProp.orElseThrow(() -> new ServiceException(errorCode, errorCode.getMessage()));
            return modelMapper.map(propEntity, PropuestaPersistDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public PropuestaPersistDTO actualizar(PropuestaPersistDTO propuesta) throws ServiceException {
        getById(propuesta.getPropuestaId());
        try {
            var propEntity = modelMapper.map(propuesta, PropuestaEntity.class);
            var propUpdated = proposalRepository.save(propEntity);
            return modelMapper.map(propUpdated, PropuestaPersistDTO.class);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public List<PropuestaPersistDTO> getAll() throws ServiceException {
        try {
            var list = proposalRepository.findAll();
            list.sort((a, b) -> a.getPropuestaId().compareTo(b.getPropuestaId()));
            return list.stream().map(element -> modelMapper.map(element, PropuestaPersistDTO.class)).collect(Collectors.toList());            
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public PropuestaPersistDTO eliminar(Integer propuestaId) throws ServiceException {
        var propDTO = getById(propuestaId);
        try {
            proposalRepository.deleteById(propuestaId);
            return propDTO;
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public PropuestaBeneficiariosDTO getAllDataById(Integer propuestaId) throws ServiceException {
        try {
            var propuestaDTO = new PropuestaBeneficiariosDTO().new PropuestaV();
            var list = vBeneficiariosDePropuestaRepository.getByPropuestaId(propuestaId);

            if (CollectionUtils.isEmpty(list)) {
                var errorCode = new ErrorCodeDTO(HttpStatus.NOT_FOUND,
                        String.format("Proposal not found with id %d", propuestaId));
                throw new ServiceException(errorCode, errorCode.getMessage());
            }

            var propEntity = list.stream().findFirst().get();
            modelMapper.map(propEntity, propuestaDTO);
            
            var benef = new ArrayList<PropuestaBeneficiariosDTO.BeneficiarioV>();
            list.forEach(beneficiario -> {
                var beneficiarioDTO = new PropuestaBeneficiariosDTO().new BeneficiarioV();
                modelMapper.map(beneficiario, beneficiarioDTO);
                benef.add(beneficiarioDTO);
            });            

            return new PropuestaBeneficiariosDTO(propuestaDTO, benef);
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public List<PropuestaPersistDTO> getResultSet(Set<FieldQueryDTO> fields) throws ServiceException {
        try {
            var listResulSet = proposalRepository.getResultSet(fields, PropuestaEntity.class);
            return listResulSet.stream().map(element -> modelMapper.map(element, PropuestaPersistDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

}
