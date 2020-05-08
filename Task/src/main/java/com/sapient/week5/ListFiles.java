package com.sapient.week5;

import java.io.File;

public class ListFiles {
    public void listFiles(String dir) {
        File currentDir = new File(dir);
        File[] files = currentDir.listFiles();

        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file.getAbsolutePath());
                } else {
                    System.out.println(file.getName());
                }
            }
        }
    }

    public static void main(String[] args) {
        ListFiles lf = new ListFiles();
        lf.listFiles("./src/main/java/com/sapient/week5/");
    }
}
