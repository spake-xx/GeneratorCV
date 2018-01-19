package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConfigReader {
    public List<String[]> readFields(String fieldsConfig){
        Scanner fieldsString = null;
        List<String[]> fields = new ArrayList<String[]>();

        try {
            fieldsString = new Scanner(new FileReader(fieldsConfig));
        }catch(FileNotFoundException e){
            System.out.println("Blad odczytu pliku z konfiguracja pol!");
        }

        if(fieldsString!=null){
            while(fieldsString.hasNextLine()){
                String line = fieldsString.nextLine();
                String fieldName = (line).split("=")[0];
                String[] fieldConfig = (line).split("=")[1].split(";");
                String[] field = {fieldName, fieldConfig[0], fieldConfig[1]};
                fields.add(field);
            }
        }

        return fields;
    }
}
