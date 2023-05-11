package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CreateTable {

    public File file;
    public  void createTable(String table_name,List<List<String>> table_details) {
        //creating table file
        FileHandler fileHandler=new FileHandler();

        // String path = "D:\\SpringbootProjects\\MikoAssignment2\\table.txt";

        //File file = new File(path);
        try {
            BufferedWriter bufferedWriter = fileHandler.bufferedWriter();
            for (int i = 0; i < table_details.size(); i++) {
                bufferedWriter.write(table_details.get(i).get(0) + "\t\t");
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        String path1 = "D:\\SpringbootProjects\\MikoAssignment2\\metadata.txt";
        File file1=new File(path1);
        try {
            BufferedWriter bufferedWriter1=new BufferedWriter(new FileWriter(file1));
           bufferedWriter1.write("table_name  :  "+table_name);
           bufferedWriter1.newLine();
            for(int i=0; i<table_details.size(); i++){
                bufferedWriter1.write((table_details.get(i).get(0))+","+table_details.get(i).get(1).substring(0,table_details.get(i).get(1).length()));
                bufferedWriter1.newLine();
            }
            bufferedWriter1.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}
