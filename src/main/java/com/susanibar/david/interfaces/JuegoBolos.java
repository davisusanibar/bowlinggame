package com.susanibar.david.interfaces;

public interface JuegoBolos {
    void jugarJuegoBolos(int... puntajesObtenidos);

    void generaraReporteCampeonato(String jugador, int contador);

    int obtenerTotalPuntos();
}
