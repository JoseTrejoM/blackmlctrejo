package com.yega.mlc.repository;


import com.yega.mlc.entity.PersonaFisicaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaFisicaRepository extends JpaRepository<PersonaFisicaEntity, Integer>, RepositoryQuery<PersonaFisicaEntity>{
    PersonaFisicaEntity findByCurp(String curp);

}
