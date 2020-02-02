package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Handles the writing of the list into a file
 */
public class SymptomListWriter {

    private final String TARGET = "result.txt";
    private List<Symptom> symptomsList;

    public SymptomListWriter(List<Symptom> symptomsList){
        this.symptomsList = symptomsList;
    }

    public void writeToFile(){
        Symptom next;
        Iterator<Symptom> iterator = this.symptomsList.iterator();
        try {
            FileWriter writer = new FileWriter(TARGET);
            while (iterator.hasNext()){
                next = iterator.next();
                writer.write(next.getName()+" = "+next.getOccurrences()+"\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
