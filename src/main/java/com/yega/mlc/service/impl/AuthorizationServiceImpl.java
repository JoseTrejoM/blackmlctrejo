package com.yega.mlc.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.yega.mlc.dto.ModuloDTO;
import com.yega.mlc.dto.PermisoDTO;
import com.yega.mlc.exception.ServiceException;
import com.yega.mlc.exception.utils.UtilsEx;
import com.yega.mlc.repository.ModuleRepository;
import com.yega.mlc.repository.PermissionRepository;
import com.yega.mlc.service.AuthorizationService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("authorizationServiceCore")
public class AuthorizationServiceImpl extends AuthorizationService{
    private static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private PermissionRepository permissionRepository;
    
    @Override
    public List<ModuloDTO> modulesUser(Integer idSistemaPadre, Integer idUsuario) throws ServiceException {
        try {
            var listModules = moduleRepository.findBySisModPadreIdAndUsuarioId(idSistemaPadre, idUsuario);
            listModules.sort((a, b) -> Integer.compare(a.getOrder(), b.getOrder()));
            return listModules.stream().map(element -> modelMapper.map(element, ModuloDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }

    @Override
    public List<PermisoDTO> permissionUser(Integer idSistema, Integer idUsuario) throws ServiceException {
        try {
            var listPermission = permissionRepository.findBySisModIdAndUsuarioId(idSistema, idUsuario);
            listPermission.sort((a, b) -> Integer.compare(a.getPermisoId(), b.getPermisoId()));
            return listPermission.stream().map(element -> modelMapper.map(element, PermisoDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            UtilsEx.showStackTraceError(e);
            throw UtilsEx.createServiceException(e);
        }
    }
}
