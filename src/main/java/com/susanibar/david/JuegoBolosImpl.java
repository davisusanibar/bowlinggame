package com.susanibar.david;

import com.susanibar.david.interfaces.JuegoBolos;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JuegoBolosImpl implements JuegoBolos {

    private static final Logger LOGGER = Logger.getLogger(JuegoBolosImpl.class.toString());

    private int posicionActual = 0;
    private int puntajeEnElJuego[] = new int [21];

    //reglas bownling
    private static final int VALOR_STRIKE_SPARE = 10;

    //reporte
    private static final String VALOR_COMPARAR_SUMA = "10";
    private static final String VALOR_COMPARAR_SLASH = "/";
    private static final String VALOR_COMPARAR_X = "X";

    @Override
    public void jugarJuegoBolos(int... puntajesObtenidos){
        reglaNegocioJuegoBolosCorrecto(puntajesObtenidos);
    }

    public void anotarPuntajeDelJuego(int bolosDerribados) {
        puntajeEnElJuego[posicionActual++] = bolosDerribados;
    }

    @Override
    @SuppressWarnings("Duplicates")
    public void generaraReporteCampeonato(String jugador, int contador) {
        //reporteria
        StringBuffer frameBuffer = new StringBuffer("Frame\t\t");
        StringBuffer pinfallsBuffer = new StringBuffer("Pinfalls\t");
        StringBuffer scoreBuffer = new StringBuffer("Score\t\t");

        int totalPuntos = 0;
        int posicion = 0;

        for (int frame = 0; frame < 10; frame++) {

            frameBuffer.append(frame + 1 + "\t\t");

            //strike
            if(puntajeEnElJuego[posicion] == VALOR_STRIKE_SPARE) {
                totalPuntos += 10 + puntajeEnElJuego[posicion + 1] + puntajeEnElJuego[posicion + 2];
                posicion += 1;
            }

            //spare
            else if(puntajeEnElJuego[posicion] + puntajeEnElJuego[posicion+1] == VALOR_STRIKE_SPARE){
                totalPuntos += 10 + puntajeEnElJuego[posicion+2];
                posicion += 2;

            //common case
            } else {
                totalPuntos += puntajeEnElJuego[posicion] + puntajeEnElJuego[posicion + 1];
                posicion += 2;
            }

            scoreBuffer.append(totalPuntos + "\t\t");
        }

        // 10 --> "X" && x + y = 10 -> posicion + 1 = "/"
        formatearPuntajesObtenidos(pinfallsBuffer);

        mostrarReporte(contador, jugador, frameBuffer, pinfallsBuffer, scoreBuffer);
    }

    private void mostrarReporte(int contador, String jugador, StringBuffer frameBuffer, StringBuffer pinfallsBuffer, StringBuffer scoreBuffer) {
        if(contador == 0)
            System.out.println(frameBuffer.toString());
        System.out.println(jugador);
        System.out.println(pinfallsBuffer);
        System.out.println(scoreBuffer);
    }

    @Override
    @SuppressWarnings("Duplicates")
    public int obtenerTotalPuntos() {
        int totalPuntos = 0;
        int posicion = 0;

        for (int frame = 0; frame < 10; frame++) {

            //strike
            if(puntajeEnElJuego[posicion] == VALOR_STRIKE_SPARE) {
                totalPuntos += 10 + puntajeEnElJuego[posicion + 1] + puntajeEnElJuego[posicion + 2];
                posicion += 1;
            }

            //spare
            else if(puntajeEnElJuego[posicion] + puntajeEnElJuego[posicion+1] == VALOR_STRIKE_SPARE){
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

    private void formatearPuntajesObtenidos(StringBuffer pinfallsBuffer) {
        String puntajeReporteEnElJuego[] =
                Arrays.stream(puntajeEnElJuego)
                        .mapToObj(String::valueOf)
                        .toArray(String[]::new);

        for (int i = 0; i < puntajeReporteEnElJuego.length-1; i++) {

            if (puntajeReporteEnElJuego[i].equalsIgnoreCase(VALOR_COMPARAR_SUMA)) {
                puntajeReporteEnElJuego[i] = "X";
            }

            if (!puntajeReporteEnElJuego[i].equalsIgnoreCase(VALOR_COMPARAR_SLASH)
                    && !puntajeReporteEnElJuego[i].equalsIgnoreCase(VALOR_COMPARAR_X)
                    && !puntajeReporteEnElJuego[i + 1].equalsIgnoreCase(VALOR_COMPARAR_SLASH)
                    && !puntajeReporteEnElJuego[i + 1].equalsIgnoreCase(VALOR_COMPARAR_X)) {

                if ((Integer.parseInt(puntajeReporteEnElJuego[i])
                        + Integer.parseInt(puntajeReporteEnElJuego[i + 1]) == VALOR_STRIKE_SPARE)
                        && Integer.parseInt(puntajeReporteEnElJuego[i + 1]) != VALOR_STRIKE_SPARE) {
                    puntajeReporteEnElJuego[i + 1] = "/";
                }
            }
            pinfallsBuffer.append(puntajeReporteEnElJuego[i] + "\t");
        }
    }

    private void reglaNegocioJuegoBolosCorrecto(int[] puntajesObtenidos) {
        for (int i = 0; i < puntajesObtenidos.length; i++) {
            if(i<=20) {
                if(puntajesObtenidos[i] >= 0 && puntajesObtenidos[i] <= 10) {
                    anotarPuntajeDelJuego(puntajesObtenidos[i]);
                } else {
                    LOGGER.log(Level.WARNING, "RULE-PUNTAJE-ENTRE-0-Y-10: Data leida fuera posibilidad juego bolos: puntajesObtenidos[" + i + "] = " + puntajesObtenidos[i]);
                    break;
                }
            } else {
                LOGGER.log(Level.WARNING, "RULE-EXISTE-MAS-21-REGISTROS: Data leida fuera posibilidad juego bolos: puntajesObtenidos[" + i + "] = " + puntajesObtenidos[i]);
                break;
            }
        }
    }
}