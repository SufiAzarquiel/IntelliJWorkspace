package org.sufiAzarquiel.tareaArchivos.rebajaVehiculo;

import java.io.*;

public class ActualizarExposicion {
    public static void main(String[] args) {
        File archivo = new File("vehiculos.obj");
        // Cargar el objeto exposicion del archivo
        System.out.println("Cargando lista de vehiculos...");
        Exposicion vehiculos = cargarExposicion(archivo);
        // Recorrer la lista de vehiculos y rebajar el precio de los que llevan mas de 5 dias en exposicion
        System.out.println("Rebajando precio de vehiculos...");
        rebajarVehiculos(5, vehiculos);
        // Guardar el objeto exposicion en el archivo (uso la funcion que ya tenia hecha)
        System.out.println("Guardando lista de vehiculos...");
        CrearExposicion.guardarExposicion(vehiculos, archivo);
    }

    public static Exposicion cargarExposicion(File archivo) {
        Exposicion vehiculos = new Exposicion();
        ObjectInputStream stream = null;

        try {
            stream = new ObjectInputStream(new FileInputStream(archivo));

            vehiculos = (Exposicion) stream.readObject();
        } catch (FileNotFoundException e) {
            // Crear nueva lista de vehiculos vacia si no encuentra el archivo
            vehiculos = new Exposicion();
        } catch (IOException e) {
            System.out.println("Error: no puedo leer el dato");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: no puedo encontrar la clase");
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException | NullPointerException e) {
                System.out.println("Error: no puedo cerrar el stream");
            }
        }

        return vehiculos;
    }

    public static void rebajarVehiculos(int dias, Exposicion exposicion) {
        for (Vehiculo vehiculo : exposicion.getVehiculos()) {
            // Si el vehiculo lleva mas de 5 dias en exposicion y no ha sido rebajado, rebajarlo
            if (vehiculo.getDiasDesdeEntrada() > dias && !vehiculo.haSidoRebajado()) {
                // Metodo que rebaja el precio del vehiculo un 5%, vease mi clase Vehiculo
                vehiculo.rebajarPrecio(15);
                vehiculo.setRebajado(true);
            }
        }
    }
}
