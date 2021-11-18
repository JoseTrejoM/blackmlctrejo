package com.yega.mlc.repository;
import com.yega.mlc.entity.PagosEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagosRepository extends JpaRepository<PagosEntity, Integer>, RepositoryQuery<PagosEntity>{
    
}
