package Model;

import java.util.LinkedList;

/**
 * This class represents a layer of neurons. It manages a collection of neurons,
 * the data and performs calculations of the function to check the activation.
 *
 * @author William Xavier Maukoski
 * @version 1.0.0.1
 */
public class NeuronLayer {

    private LinkedList<Neuron> neurons; // Linked list of neurons.
    private static double learningRate = 0.1; // Learning rate.
    private DataBase dataBases; // Linked list of data.
    private LinkedList<Integer> results;    // Stores the network's predictions for each record.
    private double accuracyTarget;  // Minimum accuracy to stop execution.
    private boolean[] equalresults; // List of hits and misses of the neural network.
    private int epoch;  // Variable used to count the number of weight updates.

    /**
     * Creates a new layer of neurons with a certain number of neurons.
     *
     * @param neuronCount The number of neurons to be created in the layer.
     * @param accuracyTarget Minimum accuracy to stop execution.
     * @throws IllegalArgumentException If the number of neurons is less than
     * zero.
     * @throws IllegalArgumentException If the minimum accuracy is less than
     * zero.
     */
    public NeuronLayer(int neuronCount, double accuracyTarget, double learningRate, DataBase db) {
        if (neuronCount <= 0) {
            throw new IllegalArgumentException("The number of neurons in a layer always must be a positive number");
        }

        if (accuracyTarget < 0) {
            throw new IllegalArgumentException("The minimum accuracy of a single layer perceptron must be equal to or greater than zero");
        }

        this.epoch = 0;
        this.accuracyTarget = accuracyTarget;
        this.learningRate = learningRate;

        this.neurons = new LinkedList<Neuron>();

        this.dataBases = db;

        // Initializing the list of neurons
        //Refactor, changing the creation of neurons to something more elegant.
        for (int i = 0; i < neuronCount; i++) {
            this.neurons.add(new Neuron(0));
        }

    }

    /**
     * Method responsible for executing all the logic behind the network, it
     * will run until the minimum accuracy is obtained
     */
    public void startProcess() {
        boolean flag = false;
        //while flag is false, keep executating
        while (!flag) {
            this.epoch++;
            this.results = new LinkedList<>();
            this.equalresults = new boolean[dataBases.size()];
            this.equalsResultInitializing();

            for (DataBase data : dataBases) {
                for (int i = 0; i < this.neurons.size(); i++) {
                    this.neurons.get(i).setInput(data.getData()[i]);
                }
                results.add(this.activation());
            }
            if (this.accuracyCalculation() >= this.accuracyTarget) {
                flag = true;
            } else {
                int i = 0;
                while (this.equalresults[i]) {
                    i++;
                }
                double error = this.errorCalculation(i);
                //Refactor, changing it to something more elegant.
                this.neurons.get(0).updateWeight(this.learningRate, error, this.dataBases.get(i).getData()[2]);
                this.neurons.get(1).updateWeight(this.learningRate, error, this.dataBases.get(i).getData()[2]);
                this.neurons.get(2).updateWeight(this.learningRate, error, this.dataBases.get(i).getData()[2]);
            }
        }
        System.out.println("" + this.epoch);
    }

    /**
     * Method that will perform the mathematical operation with the results of
     * the neurons, in this case the Summation function.
     *
     * @return Returns the result of the operation.
     */
    public double Summation() {
        double result = 0;
        for (Neuron neuron : neurons) {
            result += neuron.product();
        }
        return result;
    }

    /**
     * Method that will perform the activation function. In this case the step
     * function.
     *
     * @return Whether or not to activate.
     */
    public int activation() {
        if (this.Summation() >= 1) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Method that calculates the accuracy of the solution.
     *
     * @return accuracy
     */
    public double accuracyCalculation() {
        double accuracy = 0;
        for (int i = 0; i < dataBases.size(); i++) {
            if (this.dataBases.get(i).getData()[this.dataBases.get(i).getData().length - 1] == this.results.get(i)) {
                accuracy++;
                this.equalresults[i] = true;
            }
        }
        return ((accuracy / this.dataBases.size()) * 100);
    }

    /**
     * Method that displays the results calculated by the neural network.
     */
    public void showResult() {
        for (Integer result : results) {
            System.out.println("" + result);
        }
    }

    /**
     * Method that initializes the result array.
     */
    private void equalsResultInitializing() {
        for (int i = 0; i < this.equalresults.length; i++) {
            this.equalresults[i] = false;
        }
    }

    /**
     * Method that calculates the error of the neural network, some solutions
     * use this error to re-calculate the weights of the neurons.
     *
     * @param index parameter used to fetch the expected answer in the database.
     * @return The error of the neural network.
     */
    private double errorCalculation(int index) {
        return this.dataBases.get(index).getData()[2] - this.results.get(index);
    }

}
