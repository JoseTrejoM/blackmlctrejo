package com.yega.mlc.constants;

import org.springframework.lang.Nullable;

public enum EnumTipoPersona {
    FISICA(59), MORAL(60);

    private int value;

    private EnumTipoPersona(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public static EnumTipoPersona valueOf(int id) {
		EnumTipoPersona status = resolve(id);
		if (status == null) {
			throw new IllegalArgumentException("No matching constant for [" + id + "]");
		}
		return status;
	}

    @Nullable
	private static EnumTipoPersona resolve(int id) {
		for (EnumTipoPersona status : values()) {
			if (status.value == id) {
				return status;
			}
		}
		return null;
	}
}
