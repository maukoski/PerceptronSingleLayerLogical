/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Viewer;

import Model.DataBase;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author William
 */
public class Reader {

    private String filePath;
    private int numInputs;

    public Reader(String filePath, int numInputs) {
        this.filePath = filePath;
        this.numInputs = numInputs;
    }

    public DataBase readDatabase() {
        int[][] data = new int[(int) Math.pow(2, numInputs)][this.numInputs];  // You might want to change these values based on your use case
        int[] conclusion = new int[(int) Math.pow(2, numInputs)];

        try {
            Scanner scanner = new Scanner(new File(filePath));

            int row = 0;
            while (scanner.hasNextLine()) {
                String[] values = scanner.nextLine().split(" ");

                // Assuming that the file always has the correct format
                data[row][0] = Integer.parseInt(values[0]);
                data[row][1] = Integer.parseInt(values[1]);
                conclusion[row] = Integer.parseInt(values[2]);

                row++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        // Assuming that the logical operation is "AND" for now
        // You might want to modify this based on your use case
        return new DataBase(data, conclusion, "AND");
    }
}
