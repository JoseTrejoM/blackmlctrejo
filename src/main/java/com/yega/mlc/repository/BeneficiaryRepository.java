package com.yega.mlc.repository;

import com.yega.mlc.entity.BeneficiarioEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaryRepository extends JpaRepository<BeneficiarioEntity, Integer>, RepositoryQuery<BeneficiarioEntity> {
    
}
