package com.susanibar.david;

import java.util.Map;

public class CampeonatoBolos {

    private LecturaJugadores lecturaJugadores;
    private JuegoBolos juegoBolos;

    public CampeonatoBolos(LecturaJugadores lecturaJugadores) {
        this.lecturaJugadores = lecturaJugadores;
    }

    public void correrCampeonatoBolos(){

        if(lecturaJugadores.validarArchivoPuntajeJugadores("file/puntajeporjugador.txt")){
            Map<String, String> contenidoArchivoPuntajeJugadores = lecturaJugadores.leerArchivoPuntajeJugadores("file/puntajeporjugador-test-spare.txt");

            contenidoArchivoPuntajeJugadores
                    .entrySet()
                    .forEach(
                            jugador -> {
                                juegoBolos = new JuegoBolos();
                                System.out.println("Persona: " + jugador.getKey() + ", ListadoPuntajesObtenidos: " + jugador.getValue());

                                int[] puntajes = Util.convertirStringArregloInt(jugador.getValue());
                                juegoBolos.jugarJuegoBolos(puntajes);

                                System.out.println("TotalPuntosObtenidos: " + juegoBolos.obtenerTotalPuntos());
                            }
                    )
            ;
        } else {
            System.out.println("Error lectura de puntajes de jugadores.");
        }
    }

    public static void main(String[] args) {
        CampeonatoBolos campeonatoBolos = new CampeonatoBolos(new LecturaJugadores());

        campeonatoBolos.correrCampeonatoBolos();
    }
}
