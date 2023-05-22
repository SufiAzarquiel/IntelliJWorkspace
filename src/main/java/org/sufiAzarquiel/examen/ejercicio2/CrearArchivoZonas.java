package org.sufiAzarquiel.examen.ejercicio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CrearArchivoZonas {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		File archivo = new File("zonas.obj");
		
		ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(archivo));
		stream.writeObject(new Zona(Zona.PRINCIPAL,200,25,17));
		stream.writeObject(new Zona(Zona.PALCO,40,70,40));
		stream.writeObject(new Zona(Zona.CENTRAL,400,20,15));
		stream.writeObject(new Zona(Zona.LATERAL,100,15,10));
		stream.close();
	}

}

