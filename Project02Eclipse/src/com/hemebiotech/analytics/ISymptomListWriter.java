package com.hemebiotech.analytics;

/**
 * Anything related to the way the output is written
 */
public interface ISymptomListWriter {
    /**
     * This method writes the symptomsList to the TARGET
     */
    void writeToFile();
}
