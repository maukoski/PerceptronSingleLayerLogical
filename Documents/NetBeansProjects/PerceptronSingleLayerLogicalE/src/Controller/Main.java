/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controller;

import Model.DataBase;
import Model.NeuronLayer;



/**
 *
 * @author William
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*NeuronLayer nl = new NeuronLayer(3, 80, 0.1);
        nl.startProcess();
        nl.showResult();
        nl.accuracyCalculation();*/
        DataBase db = new DataBase(3, new int[3]);
        db.showData();
    }
    
}
