package com.hemebiotech.analytics;

public class Main {
    private static final String FILEPATH = "./Project02Eclipse/symptoms.txt";

    public static void main(String[] args) {
        new SymptomListWriter(new SymptomListReader(FILEPATH).getSymptomsList()).writeToFile();
    }
}
