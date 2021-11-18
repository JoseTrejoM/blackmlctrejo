package com.yega.mlc.repository;

import com.yega.mlc.entity.PersonaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, Integer>, RepositoryQuery<PersonaEntity>{
    
}
