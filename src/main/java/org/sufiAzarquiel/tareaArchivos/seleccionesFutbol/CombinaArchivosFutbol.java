package org.sufiAzarquiel.tareaArchivos.seleccionesFutbol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class CombinaArchivosFutbol {
    public static void main(String[] args) {
        combinaArchivos();
    }

    private static void combinaArchivos() {
        Path pathSelecciones = Path.of(
                "src/main/java/org/sufiAzarquiel/tareaArchivos/seleccionesFutbol/Selecciones.txt");

        Path pathResultado = Path.of(
                "src/main/java/org/sufiAzarquiel/tareaArchivos/seleccionesFutbol/Resultado.txt");
        try (BufferedReader brSelecciones = Files.newBufferedReader(pathSelecciones, StandardCharsets.UTF_8);
             BufferedWriter bw = Files.newBufferedWriter(pathResultado, StandardCharsets.UTF_8)) {
            String seleccion = null;
            while ((seleccion = brSelecciones.readLine()) != null) {
                System.out.println(seleccion.substring(3));
                bw.write(seleccion.substring(3));
                bw.newLine();
                imprimeJugador(seleccion, bw);
                System.out.println();
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void imprimeJugador (String seleccion, BufferedWriter bw) {
        Path pathJugadores = Path.of(
                "src/main/java/org/sufiAzarquiel/tareaArchivos/seleccionesFutbol/Jugadores.txt");
        try (BufferedReader brJugadores = Files.newBufferedReader(pathJugadores, StandardCharsets.UTF_8)) {
            String jugador = null;
            while ((jugador = brJugadores.readLine()) != null) {
                if (jugador.contains(seleccion.substring(0, 2))){
                    System.out.print(jugador.substring(0, jugador.indexOf(":") + 1));
                    bw.write(jugador.substring(0, jugador.indexOf(":") + 1));
                    imprimeDemarcacion(jugador, bw);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void imprimeDemarcacion(String jugador, BufferedWriter bw) {
        Path pathDemarcaciones = Path.of(
                "src/main/java/org/sufiAzarquiel/tareaArchivos/seleccionesFutbol/demarcaciones.txt");
        try (BufferedReader brDemarcaciones = Files.newBufferedReader(pathDemarcaciones, StandardCharsets.UTF_8)) {
            String demarcacion = null;
            while ((demarcacion = brDemarcaciones.readLine()) != null) {
                if (jugador.contains(demarcacion.substring(0, 2))){
                    System.out.println(demarcacion.substring(3));
                    bw.write(demarcacion.substring(3));
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
