package org.sufiAzarquiel.examen.ejercicio1;

import java.io.*;
import java.nio.file.Files;

public class ArreglaFichero {
    public static void main(String[] args) {
        leeNombres();
    }
    public static void leeNombres() {
        File archivo = new File("personas.txt");
        String linea;
        String nombre = "";
        String direccion = "";
        String telefono;
        try(FileReader fr = new FileReader(archivo);
                BufferedReader bf = new BufferedReader(fr)) {
            while ((linea = bf.readLine()) != null) {
                int puntoycoma = linea.indexOf(";");
                nombre = linea.substring(0, puntoycoma);
                linea = linea.substring(puntoycoma + 1);
                if (nombre.length() < 1) {
                    nombre = "Anónimo";
                }
                int puntoycoma2 = linea.indexOf(";");
                direccion = linea.substring(0, puntoycoma2);
                if (direccion.length() < 1) {
                    direccion = "Toledo";
                }
                linea = linea.substring(puntoycoma2 + 1);
                telefono = linea;
                addLinea(nombre, direccion, telefono);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        sobreescribe();
    }

    public static void addLinea(String nombre, String direccion, String telefono) {
        File archivo2 = new File("personasTemp.txt");
        try (FileWriter fw = new FileWriter(archivo2, true);
                BufferedWriter bf = new BufferedWriter(fw)) {
            bf.write((nombre + ";" + direccion + ";" + telefono));
            bf.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sobreescribe() {
        File archivo = new File("personas.txt");
        File archivo2 = new File("personasTemp.txt");
        try {
            Files.delete(archivo.toPath());
            Files.move(archivo2.toPath(), archivo.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
