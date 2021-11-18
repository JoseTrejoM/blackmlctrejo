package com.yega.mlc.repository;

import com.yega.mlc.entity.PropuestaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposalRepository extends JpaRepository<PropuestaEntity, Integer>, RepositoryQuery<PropuestaEntity>{
    
}
