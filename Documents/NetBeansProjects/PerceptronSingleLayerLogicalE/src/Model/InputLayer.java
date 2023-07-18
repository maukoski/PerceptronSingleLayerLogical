/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * This class represents a neuron in a neural network. It contains the
 * attributes input, which will store the input from the data base. The
 * attribute weight, that represents the weight of the neuron.
 *
 * @author William Xavier Maukoski
 * @version 1.1
 */
public class InputLayer {

    private double input;
    private double weight;
    private double prevWeightUpdate;
    private double gradientSum; //a atribute to keep track of the sum of squares of gradients.
    private double gradientSquareAvg;// We add an extra parameter to keep track of the moving average of the square of gradients.
    private static double decayRate = 0.9;// Decay rate for the moving average.

    /**
     * The constructor method of the InputLayer class, where the weight and
     * input are initialized to 0.*
     */
    public InputLayer() {
        this.input = 0;
        this.weight = 0;
    }

    /**
     * The constructor method of the InputLayer class, where the weight is
     * provided by the programmer.
     *
     * @param weight the weight that will be use.
     */
    public InputLayer(double weight) {
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
     * Updates the weights to minimize the error, using the gradient descent
     * approach.
     *
     * @param learningRate learning rate, provided by the user.
     * @param error Error calculated from the expected response and the response
     * predicted by the neural network.
     * @param input The input, to adjust the weights.
     */
    public void updateWeight(double learningRate, double error, double input) {
        this.weight = this.weight + (learningRate * error * input);
    }

    /**
     * Updates the weights to minimize the error, using the gradient descent
     * approach.
     *
     * @param learningRate learning rate, provided by the user.
     * @param error Error calculated from the expected response and the response
     * predicted by the neural network.
     * @param input The input, to adjust the weights.
     */
    private void gradientDescedent(double learningRate, double error, double input) {
        this.weight = this.weight + (learningRate * error * input);
    }

    /**
     * Method that updates the weights of the neurons using the Momentum method.
     * Momentum method helps the gradient descent algorithm gain momentum and
     * speed up its convergence towards minima. It does this by taking into
     * account the past gradients to smooth out the update.
     *
     * @param learningRate Learning rate defined by the user.
     * @param error The error calculated from the expected output and the
     * predicted output.
     * @param input The input, used to adjust the weights.
     * @param momentum momentum The momentum coefficient. This is a
     * hyperparameter that determines the fraction of the update vector of the
     * past time step to be added to the current update vector.
     */
    public void updateWeightWithMomentum(double learningRate, double error, double input, double momentum) {
        // Calculate the gradient
        double gradient = error * input;

        // Calculate the weight update using momentum
        double weightUpdate = momentum * prevWeightUpdate + learningRate * gradient;

        // Update the weight
        this.weight += weightUpdate;

        // Save the weight update for the next iteration
        this.prevWeightUpdate = weightUpdate;
    }

    /**
     * Updates the weights using Adaptative Gradient.
     *
     * @param learningRate learning rate, provided by the user.
     * @param error The error calculated from the expected response and the
     * response predicted by the neural network.
     * @param input The input, to adjust the weights.
     */
    public void updateWeightAdaGrad(double learningRate, double error, double input) {
        // Calculate the gradient
        double gradient = error * input;

        // Add the square of the gradient to the sum
        gradientSum += Math.pow(gradient, 2);

        // Adjust the weight, dividing the learning rate by the square root of the sum of squares of past gradients
        this.weight = this.weight + (learningRate / (Math.sqrt(gradientSum) + 1e-7)) * gradient;
    }

    /**
     * Updates the weights using RMSProp.
     *
     * @param learningRate learning rate, provided by the user.
     * @param error The error calculated from the expected response and the
     * response predicted by the neural network.
     * @param input The input, to adjust the weights.
     */
    public void updateWeightRMSProp(double learningRate, double error, double input) {
        // Calculate the gradient
        double gradient = error * input;

        // Update the moving average of the square of gradients
        gradientSquareAvg = decayRate * gradientSquareAvg + (1 - decayRate) * Math.pow(gradient, 2);

        // Adjust the weight, dividing the learning rate by the square root of the moving average of the square of past gradients
        this.weight = this.weight + (learningRate / (Math.sqrt(gradientSquareAvg) + 1e-7)) * gradient;
    }

    /**
     * Gets the value of input.
     *
     * // * @return the input value.
     */
    public double getInput() {
        return input;
    }

    /**
     * Gets the value of weight.
     *
     * @return the weight value of the neuron
     */
    public double getWeight() {
        return weight;
    }

}
