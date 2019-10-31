package com.susanibar.david;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

public class CampeonatoBolosTest {

    private LecturaJugadores lecturaJugadores;
    private Map<String, String> listaJugadores = new HashMap<String, String>();

    @Before
    public void setup() {
        lecturaJugadores = Mockito.mock(LecturaJugadores.class);
        listaJugadores.put("John", "3,7,6,3,10,8,1,10,10,9,0,7,3,4,4,10,9,0");
    }

    @Test
    public void correrCampeonatoBolos() {
        CampeonatoBolos campeonatoBolos = new CampeonatoBolos(lecturaJugadores);

        Mockito.when(
                lecturaJugadores.validarArchivoPuntajeJugadores(
                        Mockito.anyString()
                )
        ).thenReturn(true);

        Mockito.when(
                lecturaJugadores.leerArchivoPuntajeJugadores (
                        Mockito.anyString()
                )
        ).thenReturn(
            listaJugadores
        );

        campeonatoBolos.correrCampeonatoBolos();
    }
}