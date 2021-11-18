package com.yega.mlc.utils;

import java.time.LocalDate;
import java.time.Period;

import com.yega.mlc.constants.BusinessConstants;
import java.util.Calendar;
import java.util.Date;

public final class DateUtils {
    private DateUtils(){}
    
    public static Date mesesTofecha(Date fecha, int meses) {

        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fecha);
        calendario.add(calendario.MONTH, meses);
        return calendario.getTime();
    }
    
    public static Period calcularEdadByCurp(String curp){
        LocalDate ahora = LocalDate.now();        
        LocalDate fechaNac = getFechaNacimiento(curp);
        Period periodo = Period.between(fechaNac, ahora);
        return periodo;
    }

    public static LocalDate getFechaNacimiento(String curp){
        var anioCorto = curp.substring(4, 6);
        var anioEntero = isMilenial(curp) ? "20" : "19" + anioCorto;
        var anio = Integer.parseInt(anioEntero);
        var mes = Integer.parseInt(curp.substring(6, 8));
        var dia = Integer.parseInt(curp.substring(8, 10));

        LocalDate fechaNac = LocalDate.of(anio, mes, dia);
        return fechaNac;
    }

    public static boolean isMilenial(String curp){
        var anio = curp.substring(4, 6);        
        return anio.matches("^(0|1|2).*$");
    }

    public static boolean allowSegVida(String curp){
        var fechaNac = calcularEdadByCurp(curp);
        return fechaNac.getYears() < BusinessConstants.EDAD_MAX_SEG_VIDA;
    }
}
