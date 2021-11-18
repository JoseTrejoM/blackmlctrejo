package com.yega.mlc.constants;

public enum EnumEstatusPropuesta {
    PROCESO(1), POR_AUTORIZAR(2), ACEPTADA(3), CANCELADA(4);
    private int value;

    private EnumEstatusPropuesta(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
