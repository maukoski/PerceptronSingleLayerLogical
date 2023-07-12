/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * This class represents a neuron in a neural network. It contains the
 * attributes input, which will store the input from the data base. The attribute
 * weight, that represents the weight of the neuron.
 *
 * @author William Xavier Maukoski
 * @version 1.0
 */
public class Neuron {

    private double input;
    private double weight;

    public Neuron(double weight) {
        this.weight = weight;
    }

    /**
     * Performs the product between the input and the weight.
     *
     * @return the product.
     */
    public double product() {
        return this.input * weight;
    }

    /**
     * Saves the input from the database in the neuron.
     *
     * @param input Input from the data base.
     */
    public void setInput(double input) {
        this.input = input;
    }

    /**
     * Updates the weights to reduce the error.
     *
     * @param learningRate learning rate, provided by the user.
     * @param error Error calculated from the expected response and the response
     * predicted by the neural network.
     * @param input The input, to adjust the weights.
     */
    public void updateWeight(double learningRate, double error, double input) {
        this.weight = this.weight + (learningRate * error * input);
    }

}