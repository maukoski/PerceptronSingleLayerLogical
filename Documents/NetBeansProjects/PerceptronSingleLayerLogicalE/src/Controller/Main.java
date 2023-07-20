/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controller;

import Viewer.Brain;
import Viewer.StrategyWeightUpdater;
import Viewer.Writer;

/**
 *
 * @author William
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StrategyWeightUpdater strategy = new StrategyWeightUpdater(1);
        strategy.setLearningRate(0.1);
        strategy.setMomentum(0.1);
        
        Brain brain = new Brain(3, 100, 0.1, "or",strategy,"C:\\Users\\William\\Desktop\\Weights.txt");
        brain.startProcess();
        
        brain.printTable();

    }

}
