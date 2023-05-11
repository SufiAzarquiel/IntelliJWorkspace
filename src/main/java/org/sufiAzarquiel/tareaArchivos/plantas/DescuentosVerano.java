package org.sufiAzarquiel.tareaArchivos.plantas;

import java.io.*;
import java.nio.file.Files;

public class DescuentosVerano {
    public static void main(String[] args) {
        DescuentosVerano.aplicarDescuento();
    }

    public static void aplicarDescuento() {
        File archivo = new File("Plantas.venta");
        File temp = new File("Plantas.venta.temp");

        Planta currentPlanta;
        float porcentaje;

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fis = new FileInputStream(archivo);
            ois = new ObjectInputStream(fis);

            fos = new FileOutputStream(temp);
            oos = new ObjectOutputStream(fos);

            while (true) {
                try {
                    System.out.println("Leyendo...");
                    currentPlanta = (Planta) ois.readObject();

                    System.out.println("Cantidad: " + currentPlanta.getCantidad());
                    System.out.println("Precio antes: " + currentPlanta.getPrecio());

                    if (currentPlanta.getCantidad() < 10) {
                        porcentaje = 20;
                    } else if (currentPlanta.getCantidad() < 50) {
                        porcentaje = 30;
                    } else {
                        porcentaje = 40;
                    }
                    currentPlanta.setPrecio(currentPlanta.getPrecio() * (1 - porcentaje / 100));

                    System.out.println("Precio despues: " + currentPlanta.getPrecio());
                    oos.writeObject(currentPlanta);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) fis.close();
                if (ois != null) ois.close();
                if (fos != null) fos.close();
                if (oos != null) oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Renombrar el archivo temporal
        try {
            Files.delete(archivo.toPath());
            Files.move(temp.toPath(), archivo.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
