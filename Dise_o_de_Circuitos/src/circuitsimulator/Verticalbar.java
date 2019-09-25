/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package circuitsimulator;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Hassan
 */
public class Verticalbar extends JPanel {

    JRadioButton track;
    JRadioButton component;
    JRadioButton select;
    Color activeColor = Color.lightGray;
    Color inactiveColor = new Color(238,238,238);
    static Verticalbar instance;

    /**
     *
     */
    public Verticalbar() {
        instance = this;
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        JToolBar selectBar = new JToolBar(JToolBar.VERTICAL);
        this.add(selectBar);
        
        
        select = new JRadioButton("Seleccion");
        component = new JRadioButton("Componentes");
        track = new JRadioButton("Dibujar");
        
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(track);
        grupo.add(select);
        grupo.add(component);
        
       
        select.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Mouse.mode = Mouse.Mode.Select;
                setActive(e);
                         }
            
        });
        
        component.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Mouse.mode = Mouse.Mode.Component;
                setActive(e);
            }
        });
        


        track.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Mouse.mode = Mouse.Mode.Track;
                setActive(e);
            }
        });


        selectBar.add(select);
        selectBar.add(component);
        selectBar.add(track);
        selectBar.setFloatable(false);

        this.add(selectBar);
        this.add(new ComponentsViewer());

    }

    void setActive(ActionEvent e) {
        select.setBackground(inactiveColor);
        component.setBackground(inactiveColor);
        track.setBackground(inactiveColor);
        ((JButton) e.getSource()).setBackground(activeColor);
    }
    
   void setComponentActive(){
        select.setBackground(inactiveColor);
        component.setBackground(activeColor);
        track.setBackground(inactiveColor);
    }
}
