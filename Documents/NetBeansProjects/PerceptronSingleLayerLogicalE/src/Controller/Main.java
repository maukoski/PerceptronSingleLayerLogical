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
        int[] conclusion = new int[4];

       
        conclusion[3] = 1;
        conclusion[1] = 1;
        conclusion[0] = 1;

        
        
                

        DataBase db = new DataBase(2, conclusion);
    


        db.printTable();
        OutPutLayer ol = new OutPutLayer(2, 100, 0.1, db);
        ol.startProcess();
       ol.showResult();

    }

}
