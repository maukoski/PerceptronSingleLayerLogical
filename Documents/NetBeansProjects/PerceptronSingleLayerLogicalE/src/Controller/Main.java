/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controller;

import Viewer.Brain;
import Viewer.StrategyWeightUpdater;

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
        
        
        
        Brain brain = new Brain(8, 100, 0.01, "AND",strategy);
        brain.startProcess();

    }

}
