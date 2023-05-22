package org.sufiAzarquiel.tareaArchivos.comprasAzarquiel;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class CombinarCompras {
    private final static Path newPath = Path.of("comprasNuevas.obj");
    public static void main(String[] args) {
        combinacion();
        printNewCompras();
    }

    public static void printNewCompras() {
        Compra compra;
        Path path = Path.of("comprasNuevas.obj");
        try (InputStream is = Files.newInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(is)) {
            while (true) {
                try {
                    compra = (Compra) ois.readObject();
                    System.out.println(compra.getDepartamento() + " " + compra.getCantidad());
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void combinacion() {
        ArrayList<Compra> compras = new ArrayList<>();
        Compra compraRead;
        Path path = Path.of("compras.obj");
        try (InputStream is = Files.newInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(is)) {
            while (true) {
                try {
                    compraRead = (Compra) ois.readObject();
                    compras.add(compraRead);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<Compra> comprasNuevas = new ArrayList<>();
        for (Compra compra : compras) {
            if (comprasNuevas.isEmpty()) {
                comprasNuevas.add(compra);
            } else {
                boolean existe = false;
                for (Compra compraNueva : comprasNuevas) {
                    if (compra.getDepartamento().equals(compraNueva.getDepartamento())) {
                        compraNueva.setCantidad(compraNueva.getCantidad() + compra.getCantidad());
                        existe = true;
                        break;
                    }
                }
                if (!existe) {
                    comprasNuevas.add(compra);
                }
            }
        }

        try (OutputStream os = Files.newOutputStream(newPath);
             ObjectOutputStream oos = new ObjectOutputStream(os)) {
            for (Compra compra : comprasNuevas) {
                oos.writeObject(compra);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
