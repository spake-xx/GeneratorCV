package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class GeneratorCV {
    private List<Field> fields = new ArrayList<>();
    private int currentQuestion;
    private String template;

    public void loadTemplates(String templateList){
        Scanner templates = null;
        try {
            templates = new Scanner(new FileReader(templateList));
            template = templates.nextLine();
        }catch(FileNotFoundException e){
            System.out.println("Blad odczytu pliku z szablonami HTML!");
        }

        try {
            if (templates != null) template = new String(Files.readAllBytes(Paths.get(template)), StandardCharsets.UTF_8);
        }catch(IOException e){
            System.out.println("Blad odczytu pliku szablonu: "+template);
        }
    }

    public void loadFields(String fieldList){
        ConfigReader config = new ConfigReader();
        List<String[]> fields_list = config.readFields(fieldList);
        for(String[] f:fields_list){
            Field field = new Field(f[0], f[1], f[2]);
            fields.add(field);
        }
    }

    public void nextQuestion(){
        fields.get(currentQuestion++).askUser();
    }

    public boolean hasNextQuestion(){
        return currentQuestion<(fields.size());
    }

    public void renderOutputHTML(String path){
        File file = new File(path);
        String new_template = template;
        BufferedWriter writer = null;

        for(Field field:fields){
            String imie = "imie";
            new_template = new_template.replaceAll(Pattern.quote("*#"+field+"#*"), field.getHtml());
        }

        try {
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(new_template);
            writer.close();
        }catch(IOException e){
            System.out.println("Błąd zapisu do pliku!");
        }
    }
}
