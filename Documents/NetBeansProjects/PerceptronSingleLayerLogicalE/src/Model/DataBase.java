/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * The DataBase class represents a dataset used for training the neural network.
 * It contains the input data and their corresponding expected outcomes
 * (conclusion). It also provides functionality to print the dataset and fill it
 * according to different logical operations.
 *
 * @author William maukoski
 * @version 1.0
 */
public class DataBase {

    private int[][] data;
    private int[] conclusion;
    private String logicalOperation;

    /**
     * Constructor for creating a new database. The data array and conclusion
     * array will be populated based on the provided premise count and logical
     * operation.
     *
     * @param premiseCount The number of premises.
     * @param logicalOperation The logical operation used to fill the values.
     */
    public DataBase(int premiseCount, String logicalOperation) {
        this.data = new int[(int) Math.pow(2, premiseCount)][premiseCount];
        this.conclusion = new int[(int) Math.pow(2, premiseCount)];
        this.logicalOperation = logicalOperation;

    }

    /**
     * Constructor for creating a new database with predefined data and
     * conclusion arrays.
     *
     * @param data The 2D array containing the input data.
     * @param conclusion The array containing the expected outcomes.
     */
    public DataBase(int[][] data, int[] conclusion) {
        this.data = data;
        this.conclusion = conclusion;
    }

    /**
     * Prints the data array to the console.
     */
    public void printData() {
        for (int i = 0; i < data.length; i++) {
            System.out.print("Linha" + i + ": ");
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j]);
            }
            System.out.println("");
        }
    }

    /**
     * Prints the conclusion array to the console.
     */
    public void printConclusion() {
        int i = 0;
        for (int conclusion : this.conclusion) {
            System.out.println("linha " + i + ": " + conclusion);
            i++;
        }
    }

    /**
     * Prints the full dataset (data array and conclusion array) to the console.
     */
    public void printTable() {
        System.out.print("Truth Table " + this.logicalOperation.toUpperCase() + "\n");

        for (int i = 0; i < data.length; i++) {
            System.out.print("Line" + i + ": ");
            for (int j = 0; j < data[i].length; j++) {
                if (j < data[i].length - 1) {
                    System.out.print(data[i][j] + "|");
                } else {
                    System.out.print(data[i][j]);
                }
            }
            System.out.println(" =>" + this.conclusion[i]);
        }
    }

    /**
     * Retrieves the data array.
     *
     * @return the data array.
     */
    public int[][] getData() {
        return data;
    }

    /**
     * Retrieves the conclusion array.
     *
     * @return the conclusion array.
     */
    public int[] getConclusion() {
        return conclusion;
    }

    /**
     * Fills the data array based on the number of premises.
     */
    public void fillValues() {
        int numRows = data.length;
        int numCols = data[0].length;

        for (int col = 0; col < numCols; col++) {
            int period = (int) Math.pow(2, numCols - col - 1);  // calculate the period
            for (int row = 0; row < numRows; row++) {
                data[row][col] = (row / period) % 2;  // fill the column with repeating 0s and 1s
            }
        }
    }

    /**
     * Fills the conclusion array based on the logical operation.
     */
    public void fillConclusion() {
        if (this.logicalOperation.toUpperCase().equals("OR")) {
            for (int i = 1; i < this.conclusion.length; i++) {
                this.conclusion[i] = 1;
            }
        }
        if (this.logicalOperation.toUpperCase().equals("AND")) {
            this.conclusion[this.conclusion.length - 1] = 1;
        }
    }
}
