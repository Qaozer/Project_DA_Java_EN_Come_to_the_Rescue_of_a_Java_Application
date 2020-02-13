package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.util.ArrayList;

/**
 * This interface handles anything that will count and sort symptoms from a list
 */
public interface IAnalyticsCounter {
    /**
     * This method counts symptoms and returns a list
     * @return an ArrayList of symptoms
     */
    ArrayList<Symptom> count(BufferedReader reader);

    /**
     * This method is used to sort an ArrayList of symptoms
     */
    void sort(ArrayList<Symptom> symptomsList);
}
