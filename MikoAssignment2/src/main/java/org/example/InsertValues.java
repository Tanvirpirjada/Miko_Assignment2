package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class InsertValues {

   //String path = "D:\\SpringbootProjects\\MikoAssignment2\\table.txt";
CreateTable createTable=new CreateTable();
FileHandler fileHandler=new FileHandler();
    public void insertValues(List<List<String>> table_details,List<List<Object>> allValues) {
        //File file = new File(path);
        //File file=createTable.file;
        BufferedWriter bufferedWriter;

        {
            try {
                bufferedWriter = fileHandler.bufferedWriter();
                for(List<String> itr: table_details){
                    bufferedWriter.write(itr.get(0)+"("+itr.get(1)+")");
                }
                for(List<Object> obj: allValues){
                    for(int i=0; i<obj.size(); i++) {
                        bufferedWriter.write(obj.get(i)+"\t\t\t");

                    }
                    bufferedWriter.newLine();
                }
                bufferedWriter.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
