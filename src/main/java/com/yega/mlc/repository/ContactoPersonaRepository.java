package com.yega.mlc.repository;

import java.util.List;

import com.yega.mlc.entity.ContactoPersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoPersonaRepository extends JpaRepository<ContactoPersonaEntity, Integer>, RepositoryQuery<ContactoPersonaEntity>{
    List<ContactoPersonaEntity> getByPersonaId(Integer personaId);
}
