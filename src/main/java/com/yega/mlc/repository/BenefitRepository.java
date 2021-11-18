package com.yega.mlc.repository;

import com.yega.mlc.entity.ServicioBeneficiarioEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenefitRepository extends JpaRepository<ServicioBeneficiarioEntity, Integer>, RepositoryQuery<ServicioBeneficiarioEntity> {
    
}
