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
        update(attributes);
    }
    public void update(String[] attributes) throws Exception {
        getReader();
        getWriter();
        ArrayList<String> tempStore = new ArrayList<>();
        String targetID = attributes[0];
        boolean found = false;

        while(buffRead.ready() && !found) {
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
        }

        if(!found) {
            String record = "";
                for(String value : attributes) {
                    record += value;
                    record += ",";
                }
                tempStore.add(record);
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
        boolean found = false;

        while(buffRead.ready() && !found) {
            String line = buffRead.readLine();
            String[] lineArray = line.split(",");

            if(Integer.valueOf(lineArray[0]) == target) {
                value = line;
                found = true;
            }
        }

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