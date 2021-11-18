/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.repository;

import java.util.Optional;

import com.yega.mlc.entity.UsuarioEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author greser69
 */
@Repository
public interface UserRepository extends JpaRepository<UsuarioEntity, Integer>, RepositoryQuery<UsuarioEntity>{
    Optional<UsuarioEntity> findByUsuario (String usuario);
    Optional<UsuarioEntity> findByPersonaFisicaId(Integer personaFisicaId);
}
