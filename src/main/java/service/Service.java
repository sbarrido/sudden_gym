package service;

import java.io.*;
import java.util.*;

abstract class Service {
    private String fileName = "";
    private BufferedReader buffRead;
    private BufferedWriter buffWrite;

    public void setFile(String location) {
        this.fileName = location;
    }
    public void create(String[] attributes) throws Exception {
        getWriter();
        
        for(String value : attributes) {
            buffWrite.write(value);
            buffWrite.write(",");         
        }

        buffWrite.close();
    }
    public void update(String[] attributes) throws Exception {
        getReader();
        getWriter();
        ArrayList<String> tempStore = new ArrayList<>();
        String targetID = attributes[0];

        while(buffRead.ready()) {
            String line = buffRead.readLine();
            String[] lineArray = line.split(",");
            if(lineArray[0] == targetID) {
                String record = "";
                for(String value : attributes) {
                    record += value;
                    record += ",";
                }
                tempStore.add(record);
            }
            tempStore.add(line);
        }

        for(String record : tempStore) {
            buffWrite.write(record);
            buffWrite.newLine();
        }

        buffRead.close();
        buffWrite.close();

    }
    public void delete(int target) throws Exception{
        getReader();
        getWriter();
        ArrayList<String> tempStore = new ArrayList<>();

        while(buffRead.ready()) {
            String line = buffRead.readLine();
            String[] lineArray = line.split(",");
            if(lineArray[0] != Integer.toString(target)) {
                tempStore.add(line);
            }
        }

        for(String record : tempStore) {
            buffWrite.write(record);
            buffWrite.newLine();
        }

        buffRead.close();
        buffWrite.close();

    }
    public String read(int target) throws Exception {
        getReader();
        String value = null;
        int i = 0;
        boolean cond = i != target;

        while(buffRead.ready() && cond) {
            buffRead.readLine();
        }
        value = buffRead.readLine();

        return value;
    }
    public ArrayList<String> readAll() throws Exception {
        getReader();
        String line;
        ArrayList<String> values = new ArrayList<>();

        while((line = buffRead.readLine()) != null) {
            values.add(line);
        }

        return values;
    }
    private BufferedReader getReader() throws Exception {
        this.buffRead = new BufferedReader(new FileReader(this.fileName));

        return this.buffRead;
    }
    private BufferedWriter getWriter() throws Exception {
        this.buffWrite = new BufferedWriter(new FileWriter(this.fileName));

        return this.buffWrite;
    } 
}