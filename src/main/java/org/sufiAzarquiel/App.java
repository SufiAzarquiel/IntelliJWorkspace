package org.sufiAzarquiel;

import java.io.FileWriter;

public class App {
    public static void main(String[] args) {
        FileWriter writer = null;
        String path = "C:\\Users\\diurno\\Desktop\\myFile.txt";
        try {
            writer = new FileWriter(path, true);
            System.out.println("Writing line to file: " + path);
            writer.write("Lorem Ipsum is simply dummy text of the\n");
            writer.write("Lorem Ipsum is simply dummy text of the\n");
            writer.write("Lorem Ipsum is simply dummy text of the\n");
            writer.write("Lorem Ipsum is simply dummy text of the\n");
            writer.write("Lorem Ipsum is simply dummy text of the\n");
            writer.write("Lorem Ipsum is simply dummy text of the\n");
            writer.close();
        } catch (Exception e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}