package com.susanibar.david;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class LecturaJugadoresTest {

    LecturaJugadores lecturaJugadores;

    @Before
    public void setUp() throws Exception {
        lecturaJugadores = new LecturaJugadores();
    }

    @Test
    public void validarArchivoPuntajeJugadores() {
        assertEquals(true, lecturaJugadores.validarArchivoPuntajeJugadores("file/puntajeporjugador-test.txt"));
    }

    @Test
    public void leerArchivoPuntajeJugadores() {
        Map<String, String> contenidoArchivoPuntajeJugadores = lecturaJugadores.leerArchivoPuntajeJugadores("file/puntajeporjugador-test.txt");

        contenidoArchivoPuntajeJugadores.entrySet().forEach(entry -> {
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
        });
    }
}
