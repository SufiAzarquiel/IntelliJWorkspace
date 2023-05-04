package org.sufiAzarquiel.Contacto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GuardarContacto {

	public static void main(String[] args) {
		// Guardamos un objeto
		Contacto c = new Contacto("Javier", 686758483);
		
		//Objeto File
		File archivo = new File("contacto.obj");
		
		ObjectOutputStream stream;
		
		try {
			stream = new ObjectOutputStream(new FileOutputStream(archivo));
			
			//guardo el objeto
			stream.writeObject(c);

			stream.close();
			
			System.out.println("Contacto guardado");
			
		} catch (FileNotFoundException e) {
			System.out.println("Error: Archivo no encontrado");
		} catch (IOException e) {
			System.out.println("Error: no puedo escribir el dato");
			e.printStackTrace();
		}

	}

}
