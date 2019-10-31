package com.susanibar.david;

public class JuegoBolos {
    private int posicionActual = 0;
    private int puntajeEnElJuego[] = new int [21];

    public void lanzarBolos(int bolosDerribados) {
        puntajeEnElJuego[posicionActual++] = bolosDerribados;
    }

    public int obtenerTotalPuntos() {
        int totalPuntos = 0;
        int posicion = 0;

        for (int frame = 0; frame < 10; frame++) {

            //strike
            if(puntajeEnElJuego[posicion] == 10) {
                totalPuntos += 10 + puntajeEnElJuego[posicion + 1] + puntajeEnElJuego[posicion + 2];
                posicion += 1;
            }

            //spare
            else if(puntajeEnElJuego[posicion] + puntajeEnElJuego[posicion+1] == 10){
                totalPuntos += 10 + puntajeEnElJuego[posicion+2];
                posicion += 2;

                //common case
            } else {
                totalPuntos += puntajeEnElJuego[posicion] + puntajeEnElJuego[posicion + 1];
                posicion += 2;
            }
        }
        return totalPuntos;
    }
}