package org.sufiAzarquiel.Agenda;

public class Contacto implements java.io.Serializable {

	//Atributos
	private String nombre;
	private long telefono;
	
	//Constructores
	public Contacto(String nombre, long telefono) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public Contacto(long telefono) {
		super();
		this.telefono = telefono;
	}

	//Métodos
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", telefono=" + telefono + "]";
	}
	
	
	
}
