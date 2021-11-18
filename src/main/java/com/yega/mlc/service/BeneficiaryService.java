package com.yega.mlc.service;

import java.util.List;

import com.yega.mlc.dto.BeneficiarioDTO;
import com.yega.mlc.exception.ServiceException;

public interface BeneficiaryService extends ServiceBase, ServiceCRUD<BeneficiarioDTO, BeneficiarioDTO> {

    List<BeneficiarioDTO> createBeneficiary(List<BeneficiarioDTO> beneficiarios) throws ServiceException;

    void deleteByIds(List<Integer> beneficiarioIds) throws ServiceException;    
}
