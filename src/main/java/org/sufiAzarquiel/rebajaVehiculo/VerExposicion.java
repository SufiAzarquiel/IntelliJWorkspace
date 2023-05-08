package org.sufiAzarquiel.rebajaVehiculo;

import java.io.File;

public class VerExposicion {
    public static void main(String[] args) {
        File archivo = new File("vehiculos.obj");
        Exposicion exposicion = ActualizarExposicion.cargarExposicion(archivo);
        System.out.println(exposicion);
    }
}
