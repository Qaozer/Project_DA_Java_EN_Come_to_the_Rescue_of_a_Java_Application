package com.hemebiotech.reader;

import com.hemebiotech.analytics.Symptom;

import java.util.List;

/**
 * Anything that will read symptom data from a source
 */
public interface ISymptomListReader {
    /**
     * If no data is available, return an empty List
     *
     * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
     */
    List<Symptom> getSymptomsList();
}
