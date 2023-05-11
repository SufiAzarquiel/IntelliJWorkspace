package org.sufiAzarquiel.tareaArchivos.rebajaVehiculo;

import java.io.Serializable;
import java.util.Date;

public class Vehiculo implements Serializable {
    // Atributos
    private String matricula;
    private String modelo;
    private float precio;
    private Date entradaEnExposicion;
    private boolean rebajado;

    // Constructor
    public Vehiculo(String matricula, String modelo, float precio, Date entradaEnExposicion) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.precio = precio;
        this.entradaEnExposicion = entradaEnExposicion;
        rebajado = false;
    }

    // Getters y Setters
    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public boolean haSidoRebajado() {
        return rebajado;
    }

    public void setRebajado(boolean rebajado) {
        this.rebajado = rebajado;
    }

    public int getDiasDesdeEntrada() {
        Date ahora = new Date();
        long diferencia = ahora.getTime() - entradaEnExposicion.getTime();
        return (int) (diferencia / (1000 * 60 * 60 * 24));
    }

    // Metodos
    public void rebajarPrecio(float porcentaje) {
        precio = precio - (precio * porcentaje / 100);
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "matricula='" + matricula + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precio=" + precio +
                ", dias desde entrada=" + getDiasDesdeEntrada() +
                ", rebajado=" + rebajado +
                "}\n";
    }
}
