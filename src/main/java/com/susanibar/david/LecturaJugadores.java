package com.susanibar.david;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LecturaJugadores {
    public boolean validarArchivoPuntajeJugadores(String name) {
        return Paths.get(name).toFile().exists();
    }

    public Map<String, String> leerArchivoPuntajeJugadores(String archivoPuntajeJugadores) {
        Map<String, String> list = new HashMap<>();

        try (Stream<String> stream = Files.lines(Paths.get(archivoPuntajeJugadores))) {

            list = stream
                    .map(
                            w -> w.split("\\s+")
                    )
                    .collect(
                            Collectors.toMap(
                                    entry -> entry[0],
                                    entry -> entry[1],
                                    (s1, s2) -> s1 + "," + s2
                            )
                    );
            ;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void main(String[] args) {
        LecturaJugadores lecturaJugadores = new LecturaJugadores();

        lecturaJugadores.validarArchivoPuntajeJugadores("file/puntajeporjugador.txt");

        Map<String, String> listaLecturaJugadores = lecturaJugadores.leerArchivoPuntajeJugadores("file/puntajeporjugador.txt");
    }
}

