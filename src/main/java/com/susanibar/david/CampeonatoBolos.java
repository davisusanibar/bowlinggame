package com.susanibar.david;

import java.util.Map;

public class CampeonatoBolos {

    private LecturaJugadores lecturaJugadores;
    private JuegoBolos juegoBolos;

    public CampeonatoBolos(LecturaJugadores lecturaJugadores) {
        this.lecturaJugadores = lecturaJugadores;
    }

    public void correrCampeonatoBolos(String nombreArchivo){

        if(lecturaJugadores.validarArchivoPuntajeJugadores(nombreArchivo)){
            Map<String, String> contenidoArchivoPuntajeJugadores = lecturaJugadores.leerArchivoPuntajeJugadores(nombreArchivo);

            contenidoArchivoPuntajeJugadores
                    .entrySet()
                    .forEach(
                            jugador -> {
                                juegoBolos = new JuegoBolos();

                                int[] puntajes = Util.convertirStringArregloInt(jugador.getValue());
                                juegoBolos.jugarJuegoBolos(puntajes);

                                juegoBolos.generaraReporteCampeonato(jugador.getKey());
                            }
                    )
            ;
        } else {
            System.out.println("Error lectura de puntajes de jugadores.");
        }
    }

    public static void main(String[] args) {
        CampeonatoBolos campeonatoBolos = new CampeonatoBolos(new LecturaJugadores());

        campeonatoBolos
                .correrCampeonatoBolos(
                        args.length==0
                                ?"file/puntajeporjugador.txt"
                                :args[0]
                );
    }
}
