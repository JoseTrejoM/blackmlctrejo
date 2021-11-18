package com.yega.mlc.repository;

import com.yega.mlc.entity.ServicioContratadoEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioContratadoRepository extends JpaRepository<ServicioContratadoEntity, Integer>, RepositoryQuery<ServicioContratadoEntity>{
    
}
