package com.yega.mlc.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import com.yega.mlc.constants.EnumEstatusUsuario;
import com.yega.mlc.constants.SecurityConstants;
import com.yega.mlc.entity.UsuarioEntity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserDetailsDTO implements UserDetails{
    private UsuarioEntity usuarioAcceso;

    public UserDetailsDTO(UsuarioEntity usuarioAcceso) {
        this.usuarioAcceso = usuarioAcceso;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var listRols = new ArrayList<SimpleGrantedAuthority>();
        var listRolMock = Arrays.asList("API_USER", "API_CUSTOMER");
        listRolMock.forEach((String rol) -> 
            listRols.add(new SimpleGrantedAuthority(rol))
        );
        return listRols;
    }

    @Override
    public String getPassword() {
        return usuarioAcceso.getContrasena();
    }

    @Override
    public String getUsername() {
        return usuarioAcceso.getUsuario();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.usuarioAcceso.getEstatusUsuarioId() == EnumEstatusUsuario.ACTIVO.getValue() && this.usuarioAcceso.getIntentos() < SecurityConstants.INTENTOS_LOGIN;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.usuarioAcceso.getEstatusUsuarioId() == EnumEstatusUsuario.ACTIVO.getValue();
    }
}
