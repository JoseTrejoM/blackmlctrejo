package com.yega.mlc.repository;
import java.util.List;

import com.yega.mlc.entity.PermisoEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<PermisoEntity, Integer>{
    List<PermisoEntity> findBySisModIdAndUsuarioId(Integer sisModId, Integer usuarioId);
}
