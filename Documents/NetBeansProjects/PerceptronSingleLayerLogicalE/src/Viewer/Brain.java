/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Viewer;

import Model.DataBase;
import Model.OutPutLayer;

/**
 *
 * @author William
 */
public class Brain {

    private int numInputs;
    private DataBase db;
    private OutPutLayer ol;

    public Brain(int numInputs) {
        this.numInputs = numInputs;

        int[] conclusion = new int[4];

        conclusion[3] = 1;
        conclusion[1] = 1;
        conclusion[0] = 1;

        this.db = new DataBase(this.numInputs, conclusion);

        this.ol = new OutPutLayer(this.numInputs, 100, 0.1, db);

    }
    
    public void startProcess(){
        this.ol.startProcess();
    }
    
    public void printTable(){
        this.db.printTable();
    }
    
    public void printConclusion(){
        this.db.getConclusion();
    }
    
    
    

}
