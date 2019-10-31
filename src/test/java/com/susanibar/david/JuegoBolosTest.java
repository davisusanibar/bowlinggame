package com.susanibar.david;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JuegoBolosTest {

    JuegoBolos juegoBolos;

    @Before
    public void setUp() {
        juegoBolos = new JuegoBolos();
    }

    @Test
    public void lanzarBolosSinTumbarNinguna() {
        simularLanzadas(20, 0);

        assertEquals(0, juegoBolos.obtenerTotalPuntos());
    }

    @Test
    public void lanzarBolosTumbandoUno() {
        simularLanzadas(20, 1);

        assertEquals(20, juegoBolos.obtenerTotalPuntos());
    }

    @Test
    public void lanzarBolosConSpare() {
        juegoBolos.lanzarBolos(5);
        juegoBolos.lanzarBolos(5); //spare
        juegoBolos.lanzarBolos(3);
        simularLanzadas(17,0);

        assertEquals(16, juegoBolos.obtenerTotalPuntos());
    }

    @Test
    public void lanzarBolosConStrike() {
        juegoBolos.lanzarBolos(10);
        juegoBolos.lanzarBolos(3);
        juegoBolos.lanzarBolos(3);
        simularLanzadas(17, 0);

        assertEquals(22, juegoBolos.obtenerTotalPuntos());
    }

    @Test
    public void lanzarBolosConJuegoPerfecto() {
        simularLanzadas(20, 10);

        assertEquals(300, juegoBolos.obtenerTotalPuntos());
    }

    private void simularLanzadas(int totalLanzadas, int bolasTumbadas) {
        for (int i = 0; i < totalLanzadas; i++) {
            juegoBolos.lanzarBolos(bolasTumbadas);
        }
    }
}