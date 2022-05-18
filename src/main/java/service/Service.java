package service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

//Abstract Class for all services to impliment
abstract class Service {

    //Designated File to Connect
    private File fileName;

    //File Setter
    public void setFile(String location) {
        this.fileName = new File(location);
    }
    //Create new Entries
    public void create(String[] attributes) throws Exception {

        //Writers to append to fileName
        FileWriter fileWrite = new FileWriter(fileName, true);
        BufferedWriter buffWrite = new BufferedWriter(fileWrite);


        // Appends each attribute
        for(String val : attributes) {
            buffWrite.write(val);
            buffWrite.write(",");
        }
        buffWrite.write("\n");

        buffWrite.close();
    }

    //Removes target entry
    public void delete(int targetID) throws Exception {
        //Initializes Filereaders and FileWriters
        String target = null;
        FileReader fileRead = new FileReader(fileName);
        BufferedReader buffRead = new BufferedReader(fileRead);

        FileWriter fileWrite = new FileWriter(fileName);
        BufferedWriter buffWrite = new BufferedWriter(fileWrite);

        //Reads and Stores all lines that
        //do NOT contain target ID
        //pseudo-delete: rewrites all content except for designated ID
        String content = "";
        while((target = buffRead.readLine()) != null) {
            String[] targetArray = target.split(",");

            if(Integer.valueOf(targetArray[0]) != targetID) {
                content += target;
                content += "\n";
            }
        }

        buffWrite.write(content);
        buffWrite.close();
        buffRead.close();
    }

    //Finds single entry
    public String read(int targetID) throws Exception {

        //Initializes FileReaders
        String target = null;
        FileReader fileRead = new FileReader(this.fileName);
        BufferedReader buffRead = new BufferedReader(fileRead);
        String line = null;

        //Reads through all lines
        //Finds line with correct ID
        while(buffRead.ready()) {
            line = buffRead.readLine();
            String[] lineArray = line.split(",");

            if(targetID == Integer.valueOf(lineArray[0])) {
                target = line;
            }
        }

        return target;
    }
    //Fids all entries
    public String readAll() throws Exception {

        //Initializes fileReader
        String target = null;
        FileReader fileRead = new FileReader(this.fileName);
        BufferedReader buffRead = new BufferedReader(fileRead);

        //Compiles all lines into content to be returend
        String content = "";
        while((target = buffRead.readLine()) != null) {
            content += target;
            content += "\n";
        }
        
        buffRead.close();
        return content;
    }
}