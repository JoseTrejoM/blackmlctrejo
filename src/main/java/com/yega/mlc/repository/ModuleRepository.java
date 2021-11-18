package com.yega.mlc.repository;

import java.util.List;

import com.yega.mlc.entity.ModuloEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<ModuloEntity, Integer>{
    default List<ModuloEntity> findBySisModPadreIdAndUsuarioId(Integer sisModPadreId, Integer usuarioId) {
        return null;
    }
}
