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
        strategy.setMomentum(0.9);
        Brain brain = new Brain(2, 100, "AND", strategy);
        brain.startProcess(2, "C:\\Users\\William\\Desktop\\Weight.txt","C:\\Users\\William\\Desktop\\Validation Batch","C:\\Users\\William\\Desktop\\log.txt");
        

    }

}
