package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * This class defines the methods to write an ArrayList of symptoms into a file.
 */
public class SymptomListWriter implements ISymptomListWriter{

    private final String TARGET = "result.out";
    private List<Symptom> symptomsList;

    public SymptomListWriter(List<Symptom> symptomsList){
        this.symptomsList = symptomsList;
    }

    /**
     * This method writes the symptomsList to the TARGET
     */
    @Override
    public void writeToFile(){
        Symptom next;
        Iterator<Symptom> iterator = this.symptomsList.iterator();
        try (FileWriter writer = new FileWriter(TARGET)){
            while (iterator.hasNext()){
                next = iterator.next();
                writer.write(next.getName()+" = "+next.getOccurrences()+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}