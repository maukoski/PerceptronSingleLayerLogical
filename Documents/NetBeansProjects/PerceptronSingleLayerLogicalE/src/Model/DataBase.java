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
        this.data = new int[premiseCount][(int) Math.pow(2, premiseCount)];
        for (int i = 0; i < premiseCount; i++) {
            for (int j = 0; j < premiseCount; j++) {
                data[i][j] = 0;
            }
        }
    }

    public void showData() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.println("" + data[i][j]);
            }
        }
    }

    public int[][] getData() {
        return data;
    }

}
