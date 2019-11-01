package com.susanibar.david;

import com.susanibar.david.interfaces.LecturaJugadores;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class LecturaJugadoresImplTest {

    private LecturaJugadores lecturaJugadores;
    private Map<String, String> listaJugadores = new HashMap<String, String>();


    @Before
    public void setUp() {
        lecturaJugadores = Mockito.mock(LecturaJugadoresImpl.class);
        listaJugadores.put("John", "3,7,6,3,10,8,1,10,10,9,0,7,3,4,4,10,9,0");
    }

    @Test
    public void validarArchivoPuntajeJugadores() {
        Mockito.when(
                lecturaJugadores.validarArchivoPuntajeJugadores(
                        Mockito.anyString()
                )
        ).thenReturn(true);

        assertEquals(true, lecturaJugadores.validarArchivoPuntajeJugadores("file/puntajeporjugador-test.txt"));
    }

    @Test
    public void leerArchivoPuntajeJugadores() {
        Mockito.when(
                lecturaJugadores.leerArchivoPuntajeJugadores (
                        Mockito.anyString()
                )
        ).thenReturn(
                listaJugadores
        );

        assertEquals(
                1,
                lecturaJugadores.leerArchivoPuntajeJugadores(Mockito.anyString()).size()
        );
    }
}
