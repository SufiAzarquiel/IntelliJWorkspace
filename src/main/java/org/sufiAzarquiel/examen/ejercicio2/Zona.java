package org.sufiAzarquiel.examen.ejercicio2;

import java.io.Serializable;

public class Zona implements Serializable {
	public static final String PRINCIPAL = "Principal";
	public static final String PALCO = "Palco";
	public static final String CENTRAL = "Central";
	public static final String LATERAL = "Lateral";

	private String nombre;
	private int localidades;
	private float precioNormal;
	private float precioAbonado;

	public Zona(String nombre, int localidades, float precioNormal, float precioAbonado) {
		super();
		this.nombre = nombre;
		this.localidades = localidades;
		this.precioNormal = precioNormal;
		this.precioAbonado = precioAbonado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getLocalidades() {
		return localidades;
	}
	public void setLocalidades(int localidades) {
		this.localidades = localidades;
	}
	public float getPrecioNormal() {
		return precioNormal;
	}
	public void setPrecioNormal(float precioNormal) {
		this.precioNormal = precioNormal;
	}
	public float getPrecioAbonado() {
		return precioAbonado;
	}
	public void setPrecioAbonado(float precioAbonado) {
		this.precioAbonado = precioAbonado;
	}
	
	
}
