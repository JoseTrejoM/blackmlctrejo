package com.yega.mlc.repository;

import com.yega.mlc.entity.EstadoResidenciaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoResidenciaRepository extends JpaRepository<EstadoResidenciaEntity, Integer>, RepositoryQuery<EstadoResidenciaEntity>{
    
}
