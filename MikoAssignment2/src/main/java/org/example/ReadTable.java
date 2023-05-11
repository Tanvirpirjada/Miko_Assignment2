package org.example;

import java.io.*;

public class ReadTable {
   String Path="D:\\SpringbootProjects\\MikoAssignment2\\table.txt";
    public String readData(){
       File file=new File(Path);
        try {
            Reader reader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(reader);
            String s=null;
            while((s=bufferedReader.readLine())!=null){
                System.out.println(s);
            }
            return s;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
