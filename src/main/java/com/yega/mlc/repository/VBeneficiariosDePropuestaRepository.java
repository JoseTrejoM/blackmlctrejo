package com.yega.mlc.repository;

import java.util.List;

import com.yega.mlc.entity.BeneficiariosDePropuestaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VBeneficiariosDePropuestaRepository extends JpaRepository<BeneficiariosDePropuestaEntity, Integer>{
    List<BeneficiariosDePropuestaEntity> getByPropuestaId(Integer propuestaId);
}
