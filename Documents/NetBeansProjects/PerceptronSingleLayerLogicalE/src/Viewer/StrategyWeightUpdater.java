package Viewer;

/**
 * The StrategyWeightUpdater class acts as a container for hyperparameters used 
 * in the weight update strategies of a neural network.
 *
 * @author William
 */
public class StrategyWeightUpdater {
    
    private int strategy;
    private double learningRate;
    private double error;
    private double input;
    private double momentum;

    /**
     * Constructs a new StrategyWeightUpdater with a specified strategy.
     * @param strategy the weight update strategy to be used.
     *
     * 1 - Defines the strategy to update the weights as Gradient Descent.
     * 2 - Defines the strategy to update the weights as Momentum.
     * 3 - Defines the strategy to update the weights as Adaptive Gradient (AdaGrad).
     * 4 - Defines the strategy to update the weights as RMSProp.
     *
     * @throws IllegalArgumentException if the strategy number does not correspond to any known weight update methods.
     */
    public StrategyWeightUpdater(int strategy) {
        if(strategy < 1 || strategy > 4){
            throw new IllegalArgumentException("The number passed as an argument does not correspond to any weight update method. Please refer to the documentation.");
        }
        this.strategy = strategy;
    }

    /**
     * Retrieves the weight update strategy.
     *
     * @return the weight update strategy.
     */
    public int getStrategy() {
        return strategy;
    }


    /**
     * Retrieves the learning rateof the model.
     *     
     * @return the learning rate.
     */
    public double getLearningRate() {
        return learningRate;
    }

    /**
     * Sets the learning rate of the model.
     *
     * @param learningRate the learning rate to be set.
     */
    public void setLearningRate(double learningRate) {
        this.learningRate = learningRate;
    }

    /**
     * Retrieves the error.
     *
     * @return the error.
     */
    public double getError() {
        return error;
    }

    /**
     * Sets the error.
     *
     * @param error the error to be set.
     */
    public void setError(double error) {
        this.error = error;
    }

    /**
     * Retrieves the input.
     *
     * @return the input.
     */
    public double getInput() {
        return input;
    }

    /**
     * Sets the input.
     *
     * @param input the input to be set.
     */
    public void setInput(double input) {
        this.input = input;
    }

    /**
     * Retrieves the momentum.
     *
     * @return the momentum.
     */
    public double getMomentum() {
        return momentum;
    }

    /**
     * Sets the momentum.
     *
     * @param momentum the momentum to be set.
     */
    public void setMomentum(double momentum) {
        this.momentum = momentum;
    }
}