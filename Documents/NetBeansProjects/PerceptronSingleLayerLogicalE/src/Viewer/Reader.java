/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Viewer;

import Model.DataBase;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * A Reader class that provides methods for reading data from files and
 * directories. It is designed to interpret .txt files as databases, converting
 * them into DataBase objects. The class can also read a list of weights from a
 * file and return them as a LinkedList.
 *
 * The readDatabasesFromDirectory method reads all .txt files in a given
 * directory and interprets each file as a database, returning a list of
 * DataBase objects.
 *
 * The readDatabase method reads a file containing a database and returns a
 * DataBase object built from it. The file should be formatted with each row
 * representing an entry in the truth table, and each column representing a
 * premise. The last column in each row represents the conclusion.
 *
 * The readWeight method reads a file containing weights and returns them in a
 * LinkedList.
 *
 * @author William maukoski
 * @version 1.0
 */
public class Reader {

    /**
     *
     *
     * This method reads all .txt files in the given directory, interprets each
     * file as a database, and returns a list of databases.
     *
     * @param directoryPath The path of the directory where the database files
     * are located.
     * @return A LinkedList of DataBase objects, each corresponding to a .txt
     * file in the specified directory.
     */
    public LinkedList<DataBase> readDatabasesFromDirectory(String directoryPath) {
        LinkedList<DataBase> databases = new LinkedList<>();

        File folder = new File(directoryPath);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().endsWith(".txt")) {

                    DataBase db = this.readDatabase(file.getPath());
                    databases.add(db);

                }
            }
        } else {
            System.out.println("The folder is empty or does not exist.");
        }
        return databases;
    }

    /**
     * Reads a file containing a database and returns a DataBase object built
     * from it. The file should be formatted with each row representing an entry
     * in the truth table, and each column representing a premise. The last
     * column in each row represents the conclusion.
     *
     * @param filePath the path to the file containing the database.
     * @return a DataBase object containing the information read from the file,
     * or null if the file could not be read.
     */
    public DataBase readDatabase(String filePath) {
        int[][] data = null;  // We'll initialize this later
        int[] conclusion = null;  // We'll initialize this later
        Scanner scanner = null;

        try {
            scanner = new Scanner(new File(filePath));

            if (scanner.hasNextLine()) {
                String firstLine = scanner.nextLine();
                String[] firstLineValues = firstLine.split(" ");
                int columns = firstLineValues.length - 1;  // The last value is for conclusion
                int rows = (int) Math.pow(2, columns);

                data = new int[rows][columns];
                conclusion = new int[rows];

                // Process the first line
                for (int i = 0; i < columns; i++) {
                    data[0][i] = Integer.parseInt(firstLineValues[i]);
                }
                conclusion[0] = Integer.parseInt(firstLineValues[columns]);

                // Process the rest of the lines
                int row = 1;
                while (scanner.hasNextLine()) {
                    String[] values = scanner.nextLine().split(" ");
                    for (int i = 0; i < columns; i++) {
                        data[row][i] = Integer.parseInt(values[i]);
                    }
                    conclusion[row] = Integer.parseInt(values[columns]);
                    row++;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred tring to read the file.");
            e.printStackTrace();
            return null;  // Return null if the file could not be read
        } finally {
            if (scanner != null) {
                scanner.close();  // Ensure that the scanner is closed even if an exception is thrown
            }
        }

        return new DataBase(data, conclusion);
    }

    /**
     * Reads a file containing weights and returns them in a LinkedList.
     *
     * @param path the path to the file containing the weights.
     * @return a LinkedList containing the weights.
     */
    public LinkedList<Double> readWeight(String path) {
        LinkedList<Double> weights = new LinkedList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(path));
            while (scanner.hasNextLine()) {
                weights.add(Double.valueOf(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error at opening weights file: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return weights;
    }

}
