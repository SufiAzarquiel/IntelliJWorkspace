package org.sufiAzarquiel.tareaArchivos;

import java.io.*;
import java.util.StringTokenizer;

public class Cuenta {
    public static void main(String[] args) {
        File archivo = new File("C:\\Users\\diurno\\IdeaProjects\\FileManagementAndSwing\\src\\main\\resources\\tareaArchivosSources\\Ejercicio 1\\quijote.txt");
        System.out.println("El archivo tiene " + cuentaPalabras(archivo) + " palabras.");
    }

    public static String cuentaPalabras(File archivo) {
        int total = 0;
        StringTokenizer st;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                st = new StringTokenizer(linea);
                total += st.countTokens();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
                if (fr != null) fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return String.valueOf(total);
    }
}
