package service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

abstract class Service {
    private File fileName;

    public void setFile(String location) {
        this.fileName = new File(location);
    }
    public void create(String[] attributes) throws Exception {
        FileWriter fileWrite = new FileWriter(fileName, true);
        BufferedWriter buffWrite = new BufferedWriter(fileWrite);

        for(String val : attributes) {
            buffWrite.write(val);
            buffWrite.write(",");
        }
        buffWrite.write("\n");

        buffWrite.close();
    }
    public void delete(int targetID) throws Exception {
        String target = null;
        FileReader fileRead = new FileReader(fileName);
        BufferedReader buffRead = new BufferedReader(fileRead);

        FileWriter fileWrite = new FileWriter(fileName);
        BufferedWriter buffWrite = new BufferedWriter(fileWrite);
        String content = "";
        while((target = buffRead.readLine()) != null) {
            String[] targetArray = target.split(",");
            System.out.println("I entered While");

            if(Integer.valueOf(targetArray[0]) != targetID) {
                content += target;
                content += "\n";

                System.out.println("I cry");
            }
        }

        buffWrite.write(content);
        buffWrite.close();
        buffRead.close();
    }
    public String read(int targetID) throws Exception {
        String target = null;
        FileReader fileRead = new FileReader(this.fileName);
        BufferedReader buffRead = new BufferedReader(fileRead);
        String line = null;

        while(buffRead.ready()) {
            line = buffRead.readLine();
            String[] lineArray = line.split(",");

            if(targetID == Integer.valueOf(lineArray[0])) {
                target = line;
            }
        }

        return target;
    }
    public String readAll() throws Exception {
        String target = null;
        FileReader fileRead = new FileReader(this.fileName);
        BufferedReader buffRead = new BufferedReader(fileRead);

        String content = "";
        while((target = buffRead.readLine()) != null) {
            content += target;
            content += "\n";
        }
        
        buffRead.close();
        return content;
    }
}