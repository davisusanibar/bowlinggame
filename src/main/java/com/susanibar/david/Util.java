package com.susanibar.david;

import java.util.Arrays;

public class Util {
    public static int[] convertirStringArregloInt(String puntajesObtenidos){
        return Arrays.stream(puntajesObtenidos.split(","))
                .map(val -> {
                    if(val.equalsIgnoreCase("F")){
                        return "0";
                    }
                    return val;
                })
                .mapToInt(Integer::valueOf)
                .toArray();
    }
}