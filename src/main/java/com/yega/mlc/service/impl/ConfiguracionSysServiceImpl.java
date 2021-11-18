package com.yega.mlc.service.impl;

import com.yega.mlc.dto.ErrorCodeDTO;
import com.yega.mlc.entity.ConfiguracionSysEntity;
import com.yega.mlc.exception.ServiceException;
import com.yega.mlc.exception.utils.UtilsEx;
import com.yega.mlc.repository.ConfiguracionSysRepository;
import com.yega.mlc.service.ConfiguracionSysService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service("configuracionSysServiceCore")
public class ConfiguracionSysServiceImpl extends ConfiguracionSysService {
    @Autowired
    private ConfiguracionSysRepository configuracionSysRepository;

    @Override
    public ConfiguracionSysEntity parameterById(Integer configuracionId) throws ServiceException {
        try {
            var opConf = configuracionSysRepository.findById(configuracionId);
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_FOUND,
                    String.format("Config not found with id %d", configuracionId));
            return opConf.orElseThrow(() -> new ServiceException(errorCode, errorCode.getMessage()));
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public ConfiguracionSysEntity parameterByName(String name) throws ServiceException {
        try {
            var opConf = configuracionSysRepository.findByNombre(name);
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_FOUND,
                    String.format("Config not found with name %s", name));
            return opConf.orElseThrow(() -> new ServiceException(errorCode, errorCode.getMessage()));
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

}
