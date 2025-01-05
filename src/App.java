/*
 *  Title: Assignment 1 - Name Generator
 *  Created by: Robert Norlander
 *  Email: shamotar@csp.edu
 *  Date: 2025-01-05
 *  Class: CSC 420 - Data Structures and Algorithms
 *  Professor: Susan Furtney
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Created and submitted by: Robert Norlander - shamotar@csp.edu");

        // Create a FileManager object
        FileManager firstNamesFileManager = new FileManager("src/static/firstNames.txt");
        FileManager lastNamesFileManager = new FileManager("src/static/lastNames.txt");

        // Read the content of the files
        ArrayList<String> firstNames = firstNamesFileManager.read();
        ArrayList<String> lastNames = lastNamesFileManager.read();

        // Create a NameGenerator object
        NameGenerator nameGenerator = new NameGenerator(firstNames, lastNames);

        // Generate 20 random names and print them
        ArrayList<String> randomNames = nameGenerator.generateNames(20);
        printNames(randomNames, "Generated Names:");

        // Sort the names by the first name and print them
        randomNames.sort((name1, name2) -> name1.split(" ")[0].compareTo(name2.split(" ")[0]));
        printNames(randomNames, "Sorted by First Name:");

        // Create a map of first names and last names to print later
        Map<String, ArrayList<String>> namesMap = createNameMap(randomNames);

        // Sort the names by the last name and print them
        randomNames.sort((name1, name2) -> name1.split(" ")[1].compareTo(name2.split(" ")[1]));
        printNames(randomNames, "Sorted by Last Name:");

        // Special case for printing the names by first name (map)
        System.out.println("Combine all names by First Name");
        for (String firstName : namesMap.keySet()) {
            System.out.println("\t" + firstName);
            for (String lastName : namesMap.get(firstName)) {
                System.out.println("\t\t" + lastName);
            }
        }
    }

    public static void printNames(ArrayList<String> names, String title) {
        System.out.println(title);
        int i = 1;
        for (String name : names) {
            System.out.println("\t" + i + ". " + name);
            i++;
        }
    }

    public static Map<String, ArrayList<String>> createNameMap(ArrayList<String> names) {
        Map<String, ArrayList<String>> namesMap = new HashMap<String, ArrayList<String>>();
        for (String name : names) {
            String[] nameParts = name.split(" ");
            String firstName = nameParts[0];
            String lastName = nameParts[1];
            if (namesMap.containsKey(firstName)) {
                namesMap.get(firstName).add(lastName);
            } else {
                ArrayList<String> values = new ArrayList<String>();
                values.add(lastName);
                namesMap.put(firstName, values);
            }
        }
        return namesMap;
    }
}
