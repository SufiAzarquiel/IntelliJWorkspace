package org.sufiAzarquiel.tareaArchivos.rebajaVehiculo;

import java.io.*;
import java.util.Date;

public class CrearExposicion {
    public static void main(String[] args) {
        // Crear representacion del archivo
        File listaVehiculos = new File("vehiculos.obj");

        // Crear un objeto exposicion con varios vehiculos
        System.out.println("Creando lista de vehiculos...");
        Exposicion vehiculos = crearListaVehiculos();

        // Guardar el objeto exposicion en el archivo
        System.out.println("Guardando lista de vehiculos...");
        guardarExposicion(vehiculos, listaVehiculos);
    }

    public static Exposicion crearListaVehiculos() {
        Date ahora = new Date();
        Exposicion vehiculos = new Exposicion();
        Vehiculo coche1 = new Vehiculo("1234ABC", "Seat Ibiza", 10000,
                (new Date(ahora.getTime() - 4 * 24 * 60 * 60 * 1000)));
        Vehiculo coche2 = new Vehiculo("5678DEF", "Ford Focus", 15000,
                (new Date(ahora.getTime() - 3 * 24 * 60 * 60 * 1000)));
        Vehiculo coche3 = new Vehiculo("9012GHI", "Tesla S", 12000,
                (new Date(ahora.getTime() - 5 * 24 * 60 * 60 * 1000)));
        Vehiculo coche4 = new Vehiculo("3456JKL", "Renault Clio", 8000,
                (new Date(ahora.getTime() - 6 * 24 * 60 * 60 * 1000)));
        Vehiculo coche5 = new Vehiculo("7890MNO", "Opel Corsa", 9000,
                (new Date(ahora.getTime() - 10 * 24 * 60 * 60 * 1000)));

        vehiculos.addVehiculo(coche1);
        vehiculos.addVehiculo(coche2);
        vehiculos.addVehiculo(coche3);
        vehiculos.addVehiculo(coche4);
        vehiculos.addVehiculo(coche5);

        return vehiculos;
    }

    public static void guardarExposicion(Exposicion exposicion, File archivo) {
        ObjectOutputStream stream = null;

        try {
            stream = new ObjectOutputStream(new FileOutputStream(archivo));

            stream.writeObject(exposicion);
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Error: no puedo escribir el dato");
            e.printStackTrace();
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException | NullPointerException e) {
                System.out.println("Error: no puedo cerrar el stream");
            }
        }
    }
}
