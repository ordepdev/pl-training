package com.ordepdev.whatisnew.examples;

import com.ordepdev.whatisnew.FileFilter;

import java.io.File;

public class FileFilterExample {

    public static void main(String[] args) {

        // anonymous implementation
        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File file) {
                return file.getName().endsWith(".java");
            }
        };

        // using lambda expression
        FileFilter filter = (File file) -> file.getName().endsWith(".java");
    }
}
