package org.sufiAzarquiel.rebajaVehiculo;

import java.io.Serializable;
import java.util.ArrayList;

public class Exposicion implements Serializable {
    // Atributos
    private ArrayList<Vehiculo> vehiculos;

    // Constructor
    public Exposicion() {
        vehiculos = new ArrayList<Vehiculo>();
    }

    // Getters
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    // Metodos
    public void addVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    @Override
    public String toString() {
        return "Exposicion{" +
                "vehiculos=" + vehiculos +
                '}';
    }
}
