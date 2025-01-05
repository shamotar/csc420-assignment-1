/*
 *  Title: Assignment 1 - Name Generator
 *  Created by: Robert Norlander
 *  Email: shamotar@csp.edu
 *  Date: 2025-01-05
 *  Class: CSC 420 - Data Structures and Algorithms
 *  Professor: Susan Furtney
 */
import java.util.ArrayList;

public class NameGenerator {
    private ArrayList<String> firstNames;
    private ArrayList<String> lastNames;

    public NameGenerator(ArrayList<String> firstNames, ArrayList<String> lastNames) {
        this.firstNames = firstNames;
        this.lastNames = lastNames;
    }

    public String generate() {
        int firstNameIndex = (int) (Math.random() * this.firstNames.size());
        int lastNameIndex = (int) (Math.random() * this.lastNames.size());
        return this.firstNames.get(firstNameIndex) + " " + this.lastNames.get(lastNameIndex);
    }

    /*
     * @param amount - The amount of names to generate
     * @return ArrayList<String> - A list of generated names
     * @description Generates a list of random names
     */
    public ArrayList<String> generateNames(int amount) {
        ArrayList<String> names = new ArrayList<String>();
        for (int i = 0; i < amount; i++) {
            String name = this.generate();

            // If the name is already in the list, generate a new one
            while (names.contains(name)) {
                name = this.generate();
            }
            names.add(name);
        }
        return names;
    }
}
