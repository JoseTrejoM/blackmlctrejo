package com.yega.mlc.repository;

import java.util.Optional;

import com.yega.mlc.entity.ConfiguracionSysEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiguracionSysRepository extends JpaRepository<ConfiguracionSysEntity, Integer>{
    Optional<ConfiguracionSysEntity> findByNombre (String name);
}
