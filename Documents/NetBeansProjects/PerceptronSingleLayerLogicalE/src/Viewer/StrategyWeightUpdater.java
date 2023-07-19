package Viewer;

/**
 * The StrategyWeightUpdater class acts as a container for hyperparameters used 
 * in the weight update strategies of a neural network.
 *
 * @author William
 */
public class StrategyWeightUpdater {
    
    private String strategy;
    private double learningRate;
    private double error;
    private double input;
    private double momentum;

    /**
     * Constructs a new StrategyWeightUpdater with a given strategy.
     *
     * @param strategy the weight update strategy to be used.
     */
    public StrategyWeightUpdater(String strategy) {
        this.strategy = strategy;
    }

    /**
     * Retrieves the weight update strategy.
     *
     * @return the weight update strategy.
     */
    public String getStrategy() {
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