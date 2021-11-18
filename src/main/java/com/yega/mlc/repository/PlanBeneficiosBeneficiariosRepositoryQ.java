package com.yega.mlc.repository;

import java.util.List;
import java.util.Set;

import com.yega.mlc.dto.FieldQueryDTO;
import com.yega.mlc.entity.PlanBeneficiosBeneficiariosEntity;

public interface PlanBeneficiosBeneficiariosRepositoryQ {
    List<PlanBeneficiosBeneficiariosEntity> getPlan(Set<FieldQueryDTO> fields);
}
