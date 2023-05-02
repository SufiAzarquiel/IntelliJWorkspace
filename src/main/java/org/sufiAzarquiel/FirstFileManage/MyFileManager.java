package org.sufiAzarquiel.FirstFileManage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class to write to a text file
 */
public class MyFileManager {
    private FileWriter writer;
    // ---------------------------- Attributes ----------------------------

    /**
     * File to write to
     */
    private File file;

    /**
     * Path to the file
     */
    private String path;

    // ---------------------------- Constructors ----------------------------
    public MyFileManager() {
        // For now, it always points to the same file
        this.writer = null;
        this.path = "C:\\Users\\diurno\\Desktop\\myFile.txt";
        this.file = new File(path);
        this.file.setWritable(true);
    }

    // ---------------------------- Getters and Setters ----------------------------
    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    // ---------------------------- Methods ----------------------------
    /**
     * Writes a line to the file
     *
     * @param line Line to write
     */
    public void writeToFile(String line) {
        // Write to file
        try {
            writer = new FileWriter(path, true);
            System.out.println("Writing line: " + line + "\nTo file: " + path);
            writer.write(line + "\n");
            // IMPORTANT
            // Remember to close the writer
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
