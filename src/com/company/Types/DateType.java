package com.company.Types;

import java.util.Scanner;

public class DateType extends Type {
    private String[] values = new String[3];

    public String askUser(String question){
        Scanner in = new Scanner(System.in);
        System.out.println("##### "+question+" #####");

        System.out.println("Podaj dzień:");
        values[0] = in.nextLine();
        System.out.println("Podaj miesiąc:");
        values[1] = in.nextLine();
        System.out.println("Podaj rok:");
        values[2] = in.nextLine();

        return this.getHTMLValue();
    }

    public void setValues(String[] value){
        this.values = value;
    }

    public String getHTMLValue(){
        return this.values[0]+" "+this.values[1]+" "+this.values[2];
    }
}
