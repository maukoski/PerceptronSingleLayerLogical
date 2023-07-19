package Model;

import Viewer.StrategyWeightUpdater;
import java.util.LinkedList;

/**
 * This class represents a layer of neurons. It manages a collection of neurons,
 * the data and performs calculations of the function to check the activation.
 *
 * @author William Xavier Maukoski
 * @version 1.1
 */
public class OutPutLayer {

    private LinkedList<InputLayer> inputlayer; // Linked list of neurons.
    private StrategyWeightUpdater strategy;
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
    public OutPutLayer(int neuronCount, double accuracyTarget, double learningRate, DataBase db, StrategyWeightUpdater strategy) {
        if (neuronCount <= 0) {
            throw new IllegalArgumentException("The number of neurons in a layer always must be a positive number");
        }

        if (accuracyTarget < 0) {
            throw new IllegalArgumentException("The minimum accuracy of a single layer perceptron must be equal to or greater than zero");
        }

        
        this.epoch = -1;
        this.accuracyTarget = accuracyTarget;
        

        this.inputlayer = new LinkedList<>();
        this.strategy = strategy;
        this.dataBases = db;

        // Initializing the list of neurons
        //Refactor, changing the creation of neurons to something more elegant.
        for (int i = 0; i < neuronCount; i++) {
            this.inputlayer.add(new InputLayer());
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
            this.equalresults = new boolean[dataBases.getConclusion().length];
            this.equalsResultInitializing();

            this.results.clear();
            for (int[] data : dataBases.getData()) {//Access each row of the truth table.
                /*AQUI*/ for (int i = 0; i < this.inputlayer.size(); i++) {//Access the elements of the current row of the truth table.
                    this.inputlayer.get(i).setInput(data[i]); //The current element of the truth table is set as an input to the neuron.
                }
                results.add(this.activation()); //Checks if there is activation and saves in the vector used to compare with the expected answers.
            }

            if (this.accuracyCalculation() >= this.accuracyTarget) {
                flag = true;
                int i = 0;
                for (InputLayer input : this.inputlayer) {
                    System.out.println("Peso da entrada X" + i + ": " + input.getWeight());
                    i++;
                }
            } else {
                int i = 0;
                while (this.equalresults[i]) {
                    i++;
                }
                double error = this.errorCalculation(i);
                //The section that will recalculate the weights.

                for (int j = 0; j < this.dataBases.getData()[i].length; j++) {
                    this.inputlayer.get(j).updateWeight(this.strategy);
                }
            }
        }

        System.out.println("Numero de atualizacoess de peso: " + this.epoch);
        System.out.println("Acuracia obtida pela rede: " + this.accuracyCalculation() + "%");
    }

    /**
     * Method that will perform the mathematical operation with the results of
     * the neurons, in this case the Summation function.
     *
     * @return Returns the result of the operation.
     */
    public double Summation() {
        double result = 0;
        for (InputLayer input : this.inputlayer) {
            result += input.product();
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
        for (int i = 0; i < dataBases.getConclusion().length; i++) {
            if (this.dataBases.getConclusion()[i] == this.results.get(i)) {
                accuracy++;
                this.equalresults[i] = true;
            }
        }
        return ((accuracy / this.dataBases.getConclusion().length) * 100);
    }

    /**
     * Method that displays the results calculated by the neural network.
     */
    public void showResult() {
        int i = 0;
        for (Integer result : results) {
            System.out.println("Linha " + i + ": " + result);
            i++;
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
        return this.dataBases.getConclusion()[index] - this.results.get(index);
    }

}
