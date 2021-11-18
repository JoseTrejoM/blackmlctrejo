package com.yega.mlc.constants;

import org.springframework.lang.Nullable;

public enum EnumTipoUsuario {
    SIN_ASIGNAR(61), INTERNO(62), EXTERNO(63);

    private int value;

    private EnumTipoUsuario(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public static EnumTipoUsuario valueOf(int id) {
		EnumTipoUsuario status = resolve(id);
		if (status == null) {
			throw new IllegalArgumentException("No matching constant for [" + id + "]");
		}
		return status;
	}

    @Nullable
	private static EnumTipoUsuario resolve(int id) {
		for (EnumTipoUsuario status : values()) {
			if (status.value == id) {
				return status;
			}
		}
		return null;
	}
}
