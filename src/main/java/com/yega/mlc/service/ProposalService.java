package com.yega.mlc.service;

import com.yega.mlc.dto.PropuestaBeneficiariosDTO;
import com.yega.mlc.dto.PropuestaPersistDTO;
import com.yega.mlc.exception.ServiceException;

public interface ProposalService extends ServiceBase, ServiceCRUD<PropuestaPersistDTO, PropuestaPersistDTO> {    
    PropuestaBeneficiariosDTO getAllDataById(Integer propuestaId) throws ServiceException;
}
