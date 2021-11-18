package com.yega.mlc.repository;

import com.yega.mlc.entity.PlanBeneficiosBeneficiariosEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanBeneficiosBeneficiariosRepository extends JpaRepository<PlanBeneficiosBeneficiariosEntity, Integer>, PlanBeneficiosBeneficiariosRepositoryQ{
    
}
