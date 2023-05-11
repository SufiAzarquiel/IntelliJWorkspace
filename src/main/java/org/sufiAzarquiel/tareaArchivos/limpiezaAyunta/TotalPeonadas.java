package org.sufiAzarquiel.tareaArchivos.limpiezaAyunta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.StringTokenizer;

public class TotalPeonadas {
    public static void main(String[] args) {
        TotalPeonadas.calcularTotal();
    }

    public static void calcularTotal() {
        Path peonadasPath =
                Path.of("src/main/java/org/sufiAzarquiel/tareaArchivos/limpiezaAyunta/Peonadas.txt");
        Path trabajadoresPath =
                Path.of("src/main/java/org/sufiAzarquiel/tareaArchivos/limpiezaAyunta/Trabajadores.txt");
        Path resultPath =
                Path.of("src/main/java/org/sufiAzarquiel/tareaArchivos/limpiezaAyunta/TotalPeonadas.txt");

        String trabajador = null;
        try (BufferedReader brTrabajadores = Files.newBufferedReader(trabajadoresPath);
             BufferedWriter bw = Files.newBufferedWriter(resultPath)) {
            while ((trabajador = brTrabajadores.readLine()) != null) {
                int total = 0;
                String peonada = null;
                try (BufferedReader brPeonadas = Files.newBufferedReader(peonadasPath)) {
                    while ((peonada = brPeonadas.readLine()) != null) {
                        if (peonada.contains(trabajador)) {
                            total++;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(trabajador + ":" + total);
                bw.write(trabajador + ":" + total + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
