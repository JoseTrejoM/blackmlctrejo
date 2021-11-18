package com.yega.mlc.constants;

import org.springframework.lang.Nullable;

public enum EnumRolUsuario {
    ADMIN_SISTEMA(35), ADMIN_APP(36), OP_PRINCIPAL(37), OP_ASISTENTE(38), EN_COORDINADOR(39), EN_CONTACTO(40), EN_PROMOTOR(41), PROVEEDOR(42), SOPORTE(43), CLIENTE(44);

    private int value;

    private EnumRolUsuario(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public static EnumRolUsuario valueOf(int id) {
		EnumRolUsuario status = resolve(id);
		if (status == null) {
			throw new IllegalArgumentException("No matching constant for [" + id + "]");
		}
		return status;
	}

    @Nullable
	private static EnumRolUsuario resolve(int id) {
		for (EnumRolUsuario status : values()) {
			if (status.value == id) {
				return status;
			}
		}
		return null;
	}
}
