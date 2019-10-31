package com.susanibar.david;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LecturaJugadoresTest {

    LecturaJugadores lecturaJugadores;

    @Before
    public void setUp() {
        lecturaJugadores = new LecturaJugadores();
    }

    @Test
    public void validarArchivoPuntajeJugadores() {
        assertEquals(true, lecturaJugadores.validarArchivoPuntajeJugadores("file/puntajeporjugador-test.txt"));
    }
}
