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
    private int[] conclusion;

//Refatorar esta  classe
    public DataBase(int premiseCount, int[] conclusion) {
        this.data = new int[(int) Math.pow(2, premiseCount)][premiseCount];
        this.conclusion = conclusion;

        this.fillValues();
    }

    public void printData() {
        for (int i = 0; i < data.length; i++) {
            System.out.print("Linha" + i + ": ");
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j]);
            }
            System.out.println("");
        }
    }

    public void printConclusion() {
        int i = 0;
        for (int conclusion : this.conclusion) {
            System.out.println("linha " + i + ": " + conclusion);
            i++;
        }
    }

    public void printTable() {
        for (int i = 0; i < data.length; i++) {
            System.out.print("Linha" + i + ": ");
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + "|");
            }
            System.out.println("=>" + this.conclusion[i]);

        }
    }

    public int[][] getData() {
        return data;
    }

    public int[] getConclusion() {
        return conclusion;
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
