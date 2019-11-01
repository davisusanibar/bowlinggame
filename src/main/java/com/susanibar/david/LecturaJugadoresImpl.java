package com.susanibar.david;

import com.susanibar.david.interfaces.LecturaJugadores;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LecturaJugadoresImpl implements LecturaJugadores {
    @Override
    public boolean validarArchivoPuntajeJugadores(String name) {
        return Paths.get(name).toFile().exists();
    }

    @Override
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
}

