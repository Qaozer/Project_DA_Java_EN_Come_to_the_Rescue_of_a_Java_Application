package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * This will read through the txt file and compare each line to a list of symptoms
 * IF the symptom is found, adds one to the number of occurrences
 * ELSE add the symptom to the list with one occurrence
 * RETURN the list of symptoms in alphabetical order
 */
public class SymptomListReader {

    private String filePath;

    public SymptomListReader (String filePath){
        this.filePath = filePath;
    }

    public List<Symptom> getSymptomsList(){
        ArrayList<Symptom> result = new ArrayList<>();
        Optional<Symptom> checker;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();

            while(line != null){
                String finalLine = line;
                checker = result.stream().filter(symptom -> symptom.getName().equals(finalLine)).findAny();
                if(checker.isEmpty()){
                    result.add(new Symptom(line));
                } else{
                    checker.get().addOneOccurrence();
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        Collections.sort(result);
        return result;
    }
}
