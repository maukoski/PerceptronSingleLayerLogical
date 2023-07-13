/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author William
 */
public class DataBase {

    private int[][] data;

    //Refatorar esta  classe
    public DataBase(int premiseCount, int[] conclusion) {
        this.data = new int[(int) Math.pow(2, premiseCount)][premiseCount];
        this.fillValues();
    }

    public void showData() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(" " + data[i][j]);
            }
            System.out.println("");
        }
    }

    public int[][] getData() {
        return data;
    }

    private void fillValues() {
        int numRows = data.length;
        int numCols = data[0].length;

        for (int col = 0; col < numCols; col++) {
            int period = (int) Math.pow(2, numCols - col - 1);  // calculate the period
            for (int row = 0; row < numRows; row++) {
                data[row][col] = (row / period) % 2;  // fill the column with repeating 0s and 1s
            }
        }
    }
}
