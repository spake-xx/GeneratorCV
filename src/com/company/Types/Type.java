package com.company.Types;

import java.util.Scanner;

public class Type {
    private String[] values = new String[1];

    public String askUser(String question){
        Scanner in = new Scanner(System.in);
        System.out.println("##### "+question+" #####");
        values[0] = in.nextLine();

        return this.getHTMLValue();
    }

    public void setValues(String[] value){
        this.values = value;
    }

    public String getHTMLValue(){
        return this.values[0];
    }
}
