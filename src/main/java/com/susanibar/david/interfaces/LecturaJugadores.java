package com.susanibar.david.interfaces;

import java.util.Map;

public interface LecturaJugadores {
    boolean validarArchivoPuntajeJugadores(String name);

    Map<String, String> leerArchivoPuntajeJugadores(String archivoPuntajeJugadores);
}
