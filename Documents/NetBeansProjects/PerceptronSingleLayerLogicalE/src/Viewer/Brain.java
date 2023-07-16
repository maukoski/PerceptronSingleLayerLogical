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
    private double minimumAccuracy;
    private double learningRate;

    public Brain(int numInputs, double minimumAccuracy, double learningRate, String logicalOperation) {
        this.numInputs = numInputs;
        this.minimumAccuracy = minimumAccuracy;
        this.learningRate = learningRate;
        int[] conclusion = new int[4];

        conclusion[3] = 1;

        this.db = new DataBase(this.numInputs, logicalOperation);
        this.ol = new OutPutLayer(this.numInputs, this.minimumAccuracy, this.learningRate, db);
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
