package com.yega.mlc.constants;

import org.springframework.lang.Nullable;

public enum EnumContactoPersona {
    CORREO(47), TELEFONO(48), MOVIL(49);

    private int value;

    private EnumContactoPersona(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public static EnumContactoPersona valueOf(int id) {
		var status = resolve(id);
		if (status == null) {
			throw new IllegalArgumentException("No matching constant for [" + id + "]");
		}
		return status;
	}

    @Nullable
	private static EnumContactoPersona resolve(int id) {
		// Use cached VALUES instead of values() to prevent array allocation.
		for (var status : values()) {
			if (status.value == id) {
				return status;
			}
		}
		return null;
	}
}
