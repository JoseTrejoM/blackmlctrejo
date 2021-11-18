package com.yega.mlc.dto;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonaResDTO {
    private PersonaDTO persona;
    private PersonaFisicaDTO personaFisica;
    private UsuarioDTO usuario;
    private List<ContactoPersonaDTO> contactos;
}
