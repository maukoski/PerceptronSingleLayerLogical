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
    private double[]  data;

    //Refatorar esta  classe
    public DataBase(int a, int b, int c, int d) {
        data = new double[4];
        data[0] = a;
        data[1] = b;
        data[2] = c;
        data[3] = d;
    }

    public double[] getData() {
        return data;
    }
    
       
    
    
}
