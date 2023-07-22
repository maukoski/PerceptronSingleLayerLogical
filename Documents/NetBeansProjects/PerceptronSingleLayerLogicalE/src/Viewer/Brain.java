/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Viewer;

import Model.DataBase;
import Model.OutPutLayer;
import java.io.FileNotFoundException;

/**
 * This class serves as a façade, providing a unified interface between the
 * system and the neural network.
 *
 * The Brain class simplifies the interface of the underlying system, acting as
 * a point of access to the neural network. It encapsulates the complexity of
 * the system, making it easier to interact with the neural network without
 * needing to understand the inner workings. It manages the neural network's
 * operations including learning, updating weights, reading and writing from
 * databases, and more.
 *
 * @author William maukoski
 * @version 1.0
 */
public class Brain {

    private DataBase db;
    private OutPutLayer ol;

    /**
     *
     *
     * @param numInputs Number of inputs is used both to define the number of
     * premises and the number of inputs in the neuron.
     * @param minimumAccuracy Minimum accuracy to stop execution.
     *
     * @param logicalOperation The logical operation being worked on.
     * @throws IllegalArgumentException If numInputs is less than 2. zero.
     *
     */
    public Brain(int numInputs, double minimumAccuracy, String logicalOperation, StrategyWeightUpdater strategy) {
        if (numInputs < 2) {
            throw new IllegalArgumentException("The number of inputs should be greater than or equal to 2");
        }

        this.db = new DataBase(numInputs, logicalOperation);
        this.db.fillValues();
        this.db.fillConclusion();
        this.ol = new OutPutLayer(numInputs, minimumAccuracy, strategy);
    }

    /**
     * Method responsible for starting the processing.
     */
    public void startProcess(int option, String... args) {

        if (option == 1 && args.length == 1) {
            String outPutFilePath = args[0];
            this.ol.startTraining(this.db, outPutFilePath);
        }
        if (option == 2 && args.length == 3) {

            String weightFilePath = args[0];
            String trainingDirectoryPath = args[1];
            String logPath = args[2];

            Reader reader = new Reader();

            this.ol.validation(reader.readWeight(weightFilePath), reader.readDatabasesFromDirectory(trainingDirectoryPath), logPath);

        }

    }

    /**
     * Method that prints the premisses.
     */
    public void printTable() {
        this.db.printTable();
    }

    /**
     * Method that prints only the conclusions of the truth table.
     */
    public void printConclusion() {
        this.db.printConclusion();
    }
}
