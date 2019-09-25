/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package circuitsimulator;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Hassan
 */
public class Window extends JFrame {
    static Sheet sheet;
    static SimulateToolbar sim;
    static String fixedTitle = "iSee Circuits";
    static String fileName = "Untitled";
    static String title = "Diseño de Circuitos by Leonardo Guillén Fernandez 2019";
    static Window ref;
    public Window(){
        ref = this;
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        
        this.setSize(new Dimension(1000, 700));
        this.add(new Verticalbar(), BorderLayout.EAST);
        sheet = new Sheet(1000,1000);
        JScrollPane thePane = new JScrollPane(sheet);
        this.add(thePane, BorderLayout.CENTER);
        
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    static void changeTitle(String s){
        title = s+" - "+fixedTitle;
        ref.setTitle(title);
    }
}
