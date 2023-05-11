import java.io.Serializable;
import java.util.Date;

public class Vehiculo implements Serializable{
	
	private String matricula;
	private String modelo;
	private float precio;
	private Date entradaEnExposicion;
	
	
	public Vehiculo(String matricula, String modelo, float precio,
			Date entradaEnExposicion) {
		this.matricula = matricula;
		this.modelo = modelo;
		this.precio = precio;
		this.entradaEnExposicion = entradaEnExposicion;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public Date getEntradaEnExposicion() {
		return entradaEnExposicion;
	}


	public void setEntradaEnExposicion(Date entradaEnExposicion) {
		this.entradaEnExposicion = entradaEnExposicion;
	}


	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", modelo=" + modelo
				+ ", precio=" + precio + ", entradaEnExposicion="
				+ entradaEnExposicion + "]";
	}
	
	
	
	

}
