package org.sufiAzarquiel.Contacto;

import java.io.*;

public class RecuperarContacto {
    public static void main(String[] args) {
        //Objeto File
        File archivo = new File("contacto.obj");

        ObjectInputStream stream;

        try {
            stream = new ObjectInputStream(new FileInputStream(archivo));

            Contacto contactoLeido = (Contacto) stream.readObject();

            System.out.println(contactoLeido.getNombre());

            try {
                stream.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error: no puedo cerrar el stream");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Error: no puedo leer el dato");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: no puedo encontrar la clase");
        }
    }
}
