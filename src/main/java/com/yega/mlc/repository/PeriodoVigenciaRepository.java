package com.yega.mlc.repository;

import com.yega.mlc.entity.PeriodoVigenciaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodoVigenciaRepository extends JpaRepository<PeriodoVigenciaEntity, Integer>, RepositoryQuery<PeriodoVigenciaEntity>{
    
}
