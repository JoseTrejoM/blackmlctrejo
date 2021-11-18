package com.yega.mlc.constants;

public enum EnumEstatusUsuario {
    VALIDACION(10), ACTIVO(11), BLOQUEADO(12), BAJA(13), BAJA_TEMPORAL(14);

    private int value;

    private EnumEstatusUsuario(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

}
