/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Viewer;

import Model.DataBase;
import Model.OutPutLayer;

/**
 *
 * @author William
 */
public class Brain {

    private int numInputs;
    private DataBase db;
    private OutPutLayer ol;
    private double minimumAccuracy;
    private double learningRate;

    /**
     * Creates a new layer of neurons with a certain number of neurons.
     *
     * @param numInputs Number of inputs is used both to define the number of
     * premises and the number of inputs in the neuron.
     * @param minimumAccuracy Minimum accuracy to stop execution.
     * @param learningRate The weight update rate.
     * @param logicalOperation The logical operation being worked on.
     * @throws IllegalArgumentException If numInputs is less than 2. zero.
     *
     */
    public Brain(int numInputs, double minimumAccuracy, double learningRate, String logicalOperation, StrategyWeightUpdater strategy) {
        if (numInputs < 2) {
            throw new IllegalArgumentException("The number of inputs should be greater than or equal to 2");
        }

        this.numInputs = numInputs;
        this.minimumAccuracy = minimumAccuracy;
        this.learningRate = learningRate;

        this.db = new DataBase(this.numInputs, logicalOperation);
        this.ol = new OutPutLayer(this.numInputs, this.minimumAccuracy, this.learningRate, db, strategy);
    }

    /**
     * Method responsible for starting the processing.
     */
    public void startProcess() {
        this.ol.startProcess();
    }

    /**
     * Method that prints the truth table.
     */
    public void printTable() {
        this.db.printTable();
    }

    /**
     * Method that prints only the conclusions of the truth table.
     */
    public void printConclusion() {
        this.db.getConclusion();
    }
}
