package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    final String path="D:\\SpringbootProjects\\MikoAssignment2\\table.txt";

    File file=new File(path);
    final BufferedWriter bufferedWriter;

    {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public BufferedWriter bufferedWriter(){
        return bufferedWriter;
    }
}
