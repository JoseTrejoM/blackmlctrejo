package com.yega.mlc.service;

import java.util.List;

import com.yega.mlc.dto.ContactoPersonaDTO;

public interface ContactoPersonaService extends ServiceBase, ServiceCRUD<ContactoPersonaDTO, ContactoPersonaDTO>{
    List<ContactoPersonaDTO> getAllByPersonaId(Integer personaId);
    
    List<ContactoPersonaDTO> eliminarByPersonaId(Integer personaId);
}
