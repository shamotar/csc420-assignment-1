/*
 *  Title: Assignment 1 - Name Generator
 *  Created by: Robert Norlander
 *  Email: shamotar@csp.edu
 *  Date: 2025-01-05
 *  Class: CSC 420 - Data Structures and Algorithms
 *  Professor: Susan Furtney
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {
    private File file;
    private Scanner scanner;

    public FileManager(String path) {
        this.file = new File(path);
        try {
            this.scanner = new Scanner(this.file);
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /*
     * @return ArrayList<String> - The content of the file
     * @description Reads the content of the file and returns it as a list of strings
     */
    public ArrayList<String> read() {
        // If the scanner is null, return an empty list
        ArrayList<String> content = new ArrayList<String>();
        if (this.scanner == null) {
            return content;
        }

        // Read the file and return its content
        while (this.scanner.hasNextLine()) {
            content.add(this.scanner.nextLine());
        }
        return content;
    }
}
