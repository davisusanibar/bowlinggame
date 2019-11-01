package com.susanibar.david;

import com.susanibar.david.interfaces.JuegoBolos;
import com.susanibar.david.interfaces.LecturaJugadores;

import java.util.Map;

public class CampeonatoBolos {

    private LecturaJugadores lecturaJugadores;
    private JuegoBolos juegoBolos;
    private int contador = 0;

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
                                juegoBolos = new JuegoBolosImpl();

                                int[] puntajes = Util.convertirStringArregloInt(jugador.getValue());
                                juegoBolos.jugarJuegoBolos(puntajes);

                                juegoBolos.generaraReporteCampeonato(jugador.getKey(), contador);

                                contador++;
                            }
                    )
            ;
        } else {
            System.out.println("Error lectura de puntajes de jugadores.");
        }
    }

    public static void main(String[] args) {
        CampeonatoBolos campeonatoBolos = new CampeonatoBolos(new LecturaJugadoresImpl());

        campeonatoBolos
                .correrCampeonatoBolos(
                        args.length==0
                                ?"file/puntajeporjugador.txt"
                                :args[0]
                );
    }
}
