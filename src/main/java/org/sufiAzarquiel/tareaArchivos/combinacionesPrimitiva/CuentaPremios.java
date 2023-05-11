package org.sufiAzarquiel.tareaArchivos.combinacionesPrimitiva;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.StringTokenizer;

public class CuentaPremios {
    public static void main(String[] args) {
        cuentaPremios();
    }

    public static void cuentaPremios() {
        Path pathCombinaciones = Path.of(
                "src/main/java/org/sufiAzarquiel/tareaArchivos/combinacionesPrimitiva/combinaciones.txt");
        Path pathPremios = Path.of(
                "src/main/java/org/sufiAzarquiel/tareaArchivos/combinacionesPrimitiva/premios.txt");
        String combinacion;
        try (BufferedReader bfCombinaciones = Files.newBufferedReader(pathCombinaciones);
                BufferedWriter bfPremios = Files.newBufferedWriter(pathPremios)) {
            while ((combinacion = bfCombinaciones.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(combinacion, ",");
                int aciertos = 0;
                while (st.hasMoreTokens()) {
                    String token = st.nextToken();
                    if (checkCombiGanadora(token)) {
                        aciertos++;
                        System.out.println("Acierto: " + token + " en combinacion " + combinacion);
                    }
                }
                bfPremios.write(combinacion + " :" + aciertos + " aciertos");
                bfPremios.newLine();
                System.out.println("--------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkCombiGanadora(String token) {
        boolean check = false;
        Path pathGanadora = Path.of(
                "src/main/java/org/sufiAzarquiel/tareaArchivos/combinacionesPrimitiva/combiGanadora.txt");
        try (BufferedReader bfGanadora = Files.newBufferedReader(pathGanadora)) {
            String ganadora;
            ganadora = bfGanadora.readLine();
            StringTokenizer st = new StringTokenizer(ganadora, ",");
            while (st.hasMoreTokens() && !check) {
                String tokenGanador = st.nextToken();
                if (token.equals(tokenGanador)) {
                    check = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return check;
    }
}
