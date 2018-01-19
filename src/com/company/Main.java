package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        GeneratorCV generator = new GeneratorCV();
        generator.loadTemplates("templates.conf");
        generator.loadFields("fields.conf");

        do{
            generator.nextQuestion();
        }while(generator.hasNextQuestion());

        generator.renderOutputHTML("output.html");
    }
}
