package org.example;

import javax.xml.crypto.Data;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


// CREATE TABLE ( col1 INTEGER,col2 STRING)
public class Main {
    public static void main(String[] args) {
        SimpleDatabase database=new SimpleDatabase();
        database.Run();
    }
}