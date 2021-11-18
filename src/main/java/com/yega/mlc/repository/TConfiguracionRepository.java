/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.repository;

import com.yega.mlc.entity.Tconfiguracion;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  TConfiguracionRepository extends JpaRepository<Tconfiguracion, Integer>, RepositoryQuery<Tconfiguracion> {
     List<Tconfiguracion> findByNombre(String nombreVariable);
     Tconfiguracion findByConfiguracionid(Integer configuracionId);
}
