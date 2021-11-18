/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yega.mlc.constants;

import org.springframework.lang.Nullable;


/**
 *
 * @author OSCAR
 */
public enum EnumMoneda {
     MXP(25),USD(26), CND(27);
 
     private int value;

    private EnumMoneda(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
     public static EnumMoneda valueOf(int id) {
		EnumMoneda status = resolve(id);
		if (status == null) {
			throw new IllegalArgumentException("No matching constant for [" + id + "]");
		}
		return status;
	}

    @Nullable
	private static EnumMoneda resolve(int id) {
		for (EnumMoneda status : values()) {
			if (status.value == id) {
				return status;
			}
		}
		return null;
	}
}
    
