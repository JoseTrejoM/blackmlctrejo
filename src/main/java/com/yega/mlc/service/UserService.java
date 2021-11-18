/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.service;

import com.yega.mlc.dto.UsuarioDTO;
import com.yega.mlc.exception.ServiceException;

/**
 *
 * @author greser69
 */

public interface UserService extends ServiceBase, ServiceCRUD<UsuarioDTO, UsuarioDTO>{

    UsuarioDTO getUserByPersonaFisicaId(Integer personaFisicaId) throws ServiceException;

    UsuarioDTO getUserByUsuario(String usuario) throws ServiceException;

}
