/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package circuitsimulator;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Hassan
 */
public class CircuitSimulator {

    static Window win;
    static Object[][] data;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Inicio");
        win = new Window();
    }
    
    static Component classForName(String selectedComp, int x, int y) {
        Component c = null;
        switch (selectedComp) {
            case "And - 2":
                c = new And(x, y,2);
                break;
            case "And - 3":
                c = new And(x, y, 3);
                break;
            case "Or - 2":
                c = new Or(x, y,2);
                break;
            case "Or - 3":
                c = new Or(x, y, 3);
                break;
            case "Not":
                c = new Not(x, y);
                break;
            case "XOR - 2":
                c = new Xor(x, y,2);
                break;
            case "XOR - 3":
                c = new Xor(x, y, 3);
                break;
            case "XNOR - 2":
                c = new Xnor(x, y, 2);
                break;
            case "XNOR - 3":
                c = new Xnor(x, y, 3);
                break;
            case "NOR - 2":
                c = new Nor(x, y, 2);
                break;
            case "NOR - 3":
                c = new Nor(x, y, 3);
                break;
            case "NAND - 2":
                c = new Nand(x, y, 2);
                break;
            case "NAND - 3":
                c = new Nand(x, y, 3);
                break;
            case "Input":
                c = new Input(x, y);
                break;
            case "Output":
                c = new Output(x, y);
                break;
        }
        return c;
    }
}
