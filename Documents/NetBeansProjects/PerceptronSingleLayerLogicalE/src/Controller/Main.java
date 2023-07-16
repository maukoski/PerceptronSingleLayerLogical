/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controller;

import Model.DataBase;
import Model.OutPutLayer;

/**
 *
 * @author William
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] conclusion = new int[128];

        conclusion[127] = 1;
        
        
                

        DataBase db = new DataBase(7, conclusion);
    


        db.printTable();
        OutPutLayer ol = new OutPutLayer(7, 100, 0.01, db);
        ol.startProcess();
        ol.showResult();

    }

}
