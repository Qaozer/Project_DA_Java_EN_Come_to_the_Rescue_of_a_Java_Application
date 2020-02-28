package com.hemebiotech.reader;

import com.hemebiotech.analytics.AnalyticsCounter;
import com.hemebiotech.analytics.IAnalyticsCounter;
import com.hemebiotech.analytics.Symptom;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the method used to read a symptom list from a text file
 */
public class SymptomListReader implements ISymptomListReader {

    private String filePath;

    public SymptomListReader (String filePath){
        this.filePath = filePath;
    }

    /**
     * This methods reads through a file located at filepath, builds a list of symptoms from it and sorts it
     * alphabetically.
     * @return A list of symptoms in alphabetical order and their occurrences
     */
    @Override
    public List<Symptom> getSymptomsList(){
        ArrayList<Symptom> result = new ArrayList<>();
        IAnalyticsCounter analyticsCounter = new AnalyticsCounter();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            result = analyticsCounter.count(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        analyticsCounter.sort(result);
        return result;
    }
}
