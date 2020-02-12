package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

/**
 * This class defines the methods used to count the symptoms and sort them.
 */
public class AnalyticsCounter {

	/**
	 * This method builds a list of symptoms and their occurrences
	 * @param reader a buffered reader from a text file containing a list of symptoms
	 * @return an ArrayList of symptoms and their occurrences, in first appearing order.
	 */
	public ArrayList<Symptom> count(BufferedReader reader){
		ArrayList<Symptom> result = new ArrayList<>();
		Optional<Symptom> checker;

		String line;
		try {
			line = reader.readLine();
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * This methods is used to sort an ArrayList of symptoms alphabetically
	 * @param symptomsList the ArrayList to be sorted
	 */
	public void sort(ArrayList<Symptom> symptomsList){
		Collections.sort(symptomsList);
	}
}
