package com.hemebiotech.analytics;

/**
 * This object is used to represent and count the symptoms that will be encountered in the text file
 * implements Comparable in order for us to be able to sort them in ascending order
 */
public class Symptom implements Comparable{

    private String name; //The name of the symptom

    private int occurrences; //The number of time the symptom appears

    public String getName (){
        return this.name;
    }

    public int getOccurrences (){
        return this.occurrences;
    }

    public Symptom (String name){
        this.name = name;
        this.occurrences = 1;
    }

    /**
     * This methods increments by one the number of occurrences of the symptom
     */
    public void addOneOccurrence (){
        this.occurrences++;
    }

    /**
     * This methods allows us to sort two symptoms in alphabetical order
     * @param o is the second symptom
     * @return an integer used by Collections.sort()
     */
    @Override
    public int compareTo(Object o) {
        Symptom test = (Symptom) o;
        return this.getName().compareTo(test.getName());
    }
}
