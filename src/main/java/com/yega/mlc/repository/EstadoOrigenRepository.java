package com.yega.mlc.repository;

import com.yega.mlc.entity.EstadoOrigenEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoOrigenRepository extends JpaRepository<EstadoOrigenEntity, Integer>, RepositoryQuery<EstadoOrigenEntity>{
    
}
