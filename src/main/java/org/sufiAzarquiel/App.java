package org.sufiAzarquiel;

import org.sufiAzarquiel.FirstFileManage.MyFileManager;

public class App {
    public static void main(String[] args) {
        MyFileManager fileManager = new MyFileManager();
        fileManager.writeToFile("Hello World!");
        fileManager.writeToFile("Second line (same main).");
    }
}