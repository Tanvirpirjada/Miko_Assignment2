package org.example;

import java.io.*;

import java.io.*;
import java.util.*;


//inputs
/*
CREATE TABLE my_table (col1 INTEGER, col2 STRING,col3 INTEGER, col4 STRING)
INSERT INTO VALUES(1,'Tanvir',789,'Pirjada') VALUES(2,'hasnain',876,'Pirjada')
select for get table data
exit for exit the program
 */

public class SimpleDatabase {

    public void Run() {
        Scanner sc = new Scanner(System.in);
        String path1 = "D:\\SpringbootProjects\\MikoAssignment2\\table.txt";
        File file = new File(path1);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String path2 = "D:\\SpringbootProjects\\MikoAssignment2\\metadata.txt";
        File file1 = new File(path2);
        try {
            file1.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        InsertValues values=new InsertValues();
        CreateTable createTable=new CreateTable();
        ReadTable readTable=new ReadTable();
//         CREATE TABLE my_table (col1 INTEGER, col2 STRING   INSERT INTO VALUES(1,'Tanvir') VALUES(2,'hasnain')
        while(true) {
            String input = sc.nextLine().toUpperCase();
            String table_name="";
            List<List<String>> table_details = new ArrayList<>();
            if (input.contains("CREATE")) {
                String[] inputs = input.split(",\\s*|\\s+");
                table_name=inputs[2].trim();
                System.out.println(Arrays.toString(inputs));
                for (int i = 0; i < inputs.length; i++) {
                    List<String> list = new ArrayList<>();
                    if (inputs[i].contains("COL")) {
                        if (inputs[i].charAt(0) == '(') {
                            list.add(inputs[i].substring(1));
                        } else {
                            list.add(inputs[i]);
                        }
                        list.add(inputs[i + 1]);
                        if (!list.isEmpty()) {
                            table_details.add(list);
                        }
                    }
                }
                createTable.createTable(table_name,table_details);

            } else if (input.contains("INSERT")) {


                List<List<Object>> allValues = new ArrayList<>();

                // Split the INSERT statement into individual value parts
                String[] parts = input.substring(11).split("VALUES");
                for (String part : parts) {
                    part = part.trim();
                    if (!part.isEmpty()) {
                        // Extract the values from each part
                        String[] val = part.substring(1, part.length() - 1).split(",");
                        List<Object> row = new ArrayList<>();
                        for (String value : val) {
                            value = value.trim();
                            // Remove single quotes if present
                            if (value.startsWith("'") && value.endsWith("'")) {
                                value = value.substring(1, value.length() - 1);
                            }
                            row.add(value);
                        }
                        allValues.add(row);
                    }
                }

                // Print the extracted values
//                for (List<Object> row : allValues) {
//                    System.out.println(row);
//                }
                values.insertValues(table_details,allValues);
            }
            else if(input.contains("SELECT")){
                readTable.readData();
            }
            else if (input.contains("EXIT")){
                break;
            }
        }
    }
}