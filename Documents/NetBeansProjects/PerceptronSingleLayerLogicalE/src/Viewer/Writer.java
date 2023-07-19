/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Viewer;

import Model.InputLayer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author William
 */
public class Writer {

    private String filePath;

    /**
     * Constructs a WeightWriter that writes to a specified file.
     *
     * @param filePath The path to the file where the weights will be written.
     */
    public Writer(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Writes the weights, after the train to the file.
     *
     * @param inputs The weights to be written to the file.
     * @throws IOException If an I/O error occurs.
     */
    public void writeWeights(LinkedList<InputLayer> inputs) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (InputLayer input : inputs) {
                writer.write(Double.toString(input.getWeight()));
                writer.newLine();
            }
        }
    }

}
