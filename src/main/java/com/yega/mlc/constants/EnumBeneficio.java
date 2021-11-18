package com.yega.mlc.constants;

import org.springframework.lang.Nullable;

public enum EnumBeneficio {
    REPATRIACION_A_MEXICO(1), SERVICIO_FUNERARIO(2), SEGURO_DE_VIDA(3), EDUCACION_FINANCIERA(4), ENVIO_DE_DINERO(5), SEGURO_VIDA_PAREJA(6), SEG_VIDA_AD_100_TITULAR(7), SEG_VIDA_AD_100_PAREJA(8), SEG_VIDA_AD_200_TITULAR(9), SEG_VIDA_AD_200_PAREJA(10), ASISTENCIAS_ADICIONALES(11), SEG_GASTOS_MED_NTER(12), MEM_SALUD_INTELIGENTE(13), SEG_GASTOS_MED_MEX_AZUL(14), SEG_GASTOS_MED_MEX_GNP(15);

    private int value;

    private EnumBeneficio(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public static EnumBeneficio valueOf(int beneficioId) {
		EnumBeneficio status = resolve(beneficioId);
		if (status == null) {
			throw new IllegalArgumentException("No matching constant for [" + beneficioId + "]");
		}
		return status;
	}

    @Nullable
	private static EnumBeneficio resolve(int beneficioId) {
		// Use cached VALUES instead of values() to prevent array allocation.
		for (EnumBeneficio status : values()) {
			if (status.value == beneficioId) {
				return status;
			}
		}
		return null;
	}
}
