package com.yega.mlc.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yega.mlc.dto.FieldQueryDTO;
import com.yega.mlc.dto.PlanBeneficiosBeneficiariosDTO;
import com.yega.mlc.exception.ServiceException;

public interface PlanBeneficiosBeneficiariosService extends ServiceBase {

    List<PlanBeneficiosBeneficiariosDTO> getAllPlans() throws ServiceException;

    List<PlanBeneficiosBeneficiariosDTO> getPlans(Set<FieldQueryDTO> fields) throws ServiceException;

    PlanBeneficiosBeneficiariosDTO getPlan(String curp, Map<Integer, List<Integer>> beneficioBeneficiarios);
}
