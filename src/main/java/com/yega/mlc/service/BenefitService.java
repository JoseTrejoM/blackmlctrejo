package com.yega.mlc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yega.mlc.dto.FieldQueryDTO;
import com.yega.mlc.dto.ServicioBeneficiarioDTO;
import com.yega.mlc.exception.ServiceException;

public abstract class BenefitService {
    protected Map<String, String> configServiceMap;

    public abstract ServicioBeneficiarioDTO createBenefit(ServicioBeneficiarioDTO beneficio) throws ServiceException;

    public abstract List<ServicioBeneficiarioDTO> createBenefit(List<ServicioBeneficiarioDTO> beneficios) throws ServiceException;

    public abstract void deleteById(Integer beneficioId) throws ServiceException;

    public abstract void deleteByIds(List<Integer> beneficioIds) throws ServiceException;

    public abstract List<ServicioBeneficiarioDTO> getResultSet(Set<FieldQueryDTO> fields) throws ServiceException;
    
    public BenefitService setConfig(Map<String, String> headers) {
        configServiceMap = new HashMap<String, String>();
        headers.forEach((k, v) -> configServiceMap.put(k, v));
        return this;
    }
}
