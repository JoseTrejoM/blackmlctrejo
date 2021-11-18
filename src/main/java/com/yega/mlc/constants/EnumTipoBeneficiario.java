package com.yega.mlc.constants;

import org.springframework.lang.Nullable;

public enum EnumTipoBeneficiario {
    TITULAR(15), PAREJA(16), PADRE(17), MADRE(18), HIJO(19);

    private int value;

    private EnumTipoBeneficiario(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public static EnumTipoBeneficiario valueOf(int tipoBeneficiarioId) {
		EnumTipoBeneficiario status = resolve(tipoBeneficiarioId);
		if (status == null) {
			throw new IllegalArgumentException("No matching constant for [" + tipoBeneficiarioId + "]");
		}
		return status;
	}

    @Nullable
	private static EnumTipoBeneficiario resolve(int tipoBeneficiarioId) {
		// Use cached VALUES instead of values() to prevent array allocation.
		for (EnumTipoBeneficiario status : values()) {
			if (status.value == tipoBeneficiarioId) {
				return status;
			}
		}
		return null;
	}
}
