package org.sufiAzarquiel.examen.ejercicio2;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

public class Ejercicio2 {

	private static File archivoZonas = new File("zonas.obj");
	
	public static void main(String[] args) {
		// Obtengo los objetos zona
		ArrayList<Zona> listaZonas = getZonas();
		for (Zona zona : listaZonas) {
			System.out.println(zona.getLocalidades());
		}
		// Vendo 10 entradas de la zona "Palco"
		vender(Zona.PALCO,10);
		// Obtengo los objetos de nuevo
		listaZonas = getZonas();
		for (Zona zona : listaZonas) {
			System.out.println(zona.getLocalidades());
		}
	}

	public static ArrayList<Zona> getZonas(){
		try(InputStream is = Files.newInputStream(archivoZonas.toPath());
			ObjectInputStream ois = new ObjectInputStream(is)){
			ArrayList<Zona> listaZonas = new ArrayList<>();
			while(true) {
				try {
					Zona zona = (Zona) ois.readObject();
					listaZonas.add(zona);
				} catch (EOFException e) {
					break;
				}
			}
			return listaZonas;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void vender(String nombreZona, int numeroEntradasVendidas) {
		File archivoTemp = new File("zonasTemp.obj");
		ArrayList<Zona> listaZonas = getZonas();
		for(Zona zona: listaZonas) {
			if(zona.getNombre().equals(nombreZona)) {
				zona.setLocalidades(zona.getLocalidades()-numeroEntradasVendidas);
			}
		}
		try (OutputStream os = Files.newOutputStream(archivoTemp.toPath());
			ObjectOutputStream oos = new ObjectOutputStream(os)){
			for(Zona zona: listaZonas) {
				oos.writeObject(zona);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			// Borro el archivo original
			Files.delete(archivoZonas.toPath());
			// Renombro el archivo temporal
			Files.move(archivoTemp.toPath(), archivoZonas.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
}
