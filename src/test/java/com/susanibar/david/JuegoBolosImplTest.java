package com.susanibar.david;

import com.susanibar.david.interfaces.JuegoBolos;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JuegoBolosImplTest {

    JuegoBolos juegoBolos;

    @Before
    public void setUp() {
        juegoBolos = new JuegoBolosImpl();
    }

    @Test
    public void lanzarBolosSinTumbarNinguna() {
        juegoBolos.jugarJuegoBolos(0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);

        assertEquals(0, juegoBolos.obtenerTotalPuntos());
    }

    @Test
    public void lanzarBolosTumbandoUno() {
        juegoBolos.jugarJuegoBolos(1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1);

        assertEquals(20, juegoBolos.obtenerTotalPuntos());
    }

    @Test
    public void lanzarBolosConSpare() {
        juegoBolos.jugarJuegoBolos(5,5, 3,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);


        assertEquals(16, juegoBolos.obtenerTotalPuntos());
    }

    @Test
    public void lanzarBolosConStrike() {
        juegoBolos.jugarJuegoBolos(10, 3,3, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);


        assertEquals(22, juegoBolos.obtenerTotalPuntos());
    }

    @Test
    public void lanzarBolosConJuegoPerfecto() {
        juegoBolos.jugarJuegoBolos(10,10, 10,10, 10,10, 10,10, 10,10, 10,10, 10,10, 10,10, 10,10, 10,10);

        assertEquals(300, juegoBolos.obtenerTotalPuntos());
    }
}