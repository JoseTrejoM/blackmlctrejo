package com.yega.mlc.constants;

public final class BusinessConstants {

    private BusinessConstants() {
    }

    public static final int EDAD_PLAN_ACCESO = 56;
    public static final int EDAD_MAX_SEG_VIDA = 60;

    public static class Plan {

        private Plan() {
        }

        public static final String CAMPO_PROGRAMA = "PROGRAMA";
        public static final String CAMPO_EDAD_MINIMA = "EDADMINIMA";
        public static final String CAMPO_EDAD_MAXIMA = "EDADMAXIMA";
        public static final int PROGRAMA_1 = 1;
        public static final int PROGRAMA_2 = 2;
    }

    public static class Correos {

        private Correos() {
        }

        public static final String USUARIO = "CorreoUsuario";
        public static final String RECUPERAR_CONTRASENIA = "CorreoRecuperacion";
        public static final String CONTRATACION = "CorreoContratacion";
        public static final String BIENVENIDA = "CorreoBienvenida";
        public static final String VALIDAR_ACCESO = "CorreoConfirmacion";
    }

}
