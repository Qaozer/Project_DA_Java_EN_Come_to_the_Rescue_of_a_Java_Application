package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

/**
 * This class defines the methods used to count the symptoms and sort them.
 */
public class AnalyticsCounter implements IAnalyticsCounter {

	/**
	 * This method builds a list of symptoms and their occurrences
	 * @param reader a buffered reader from a text file containing a list of symptoms
	 * @return an ArrayList of symptoms and their occurrences, in first appearing order.
	 */
	@Override
	public ArrayList<Symptom> count(BufferedReader reader){
		ArrayList<Symptom> result = new ArrayList<>();

		String line;
		try {
			line = reader.readLine();
			while(line != null){
				add(line,result);
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
	@Override
	public void sort(ArrayList<Symptom> symptomsList){
		Collections.sort(symptomsList);
	}

	/**
	 * This method defines how the symptoms are counted and added to the list
	 */
	@Override
	public void add(String line, ArrayList<Symptom> list){
		Optional<Symptom> checker;
		checker = list.stream().filter(symptom -> symptom.getName().equals(line)).findAny();
		if(checker.isEmpty()){
			list.add(new Symptom(line));
		} else{
			checker.get().addOneOccurrence();
		}
	}
}
