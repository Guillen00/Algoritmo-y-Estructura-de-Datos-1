package circuitsimulator;

import java.awt.event.*;
import javax.swing.*;

/** Nos da una barra de herramientas que tiene 2 botones los cuales se pueden seleccionar y tomar así una
 * funcion especifica mientras estan marcados 
 *
 * 
 */
public class Verticalbar extends JPanel {

    JRadioButton track;
    JRadioButton component;
    static Verticalbar instance;

    public Verticalbar() {
        instance = this;
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        JToolBar selectBar = new JToolBar(JToolBar.VERTICAL);
        this.add(selectBar);
        
      
        component = new JRadioButton("Componentes");
        track = new JRadioButton("Dibujar");
        
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(track);
        grupo.add(component);
        
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
        selectBar.add(component);
        selectBar.add(track);
        selectBar.setFloatable(false);

        this.add(selectBar);
        this.add(new ComponentsViewer());

    }

    void setActive(ActionEvent e) {
        component.setSelected(false);
        track.setSelected(false);
        ((JRadioButton) e.getSource()).setSelected(true);
    }
    
   void setComponentActive(){
        component.setSelected(true);
        track.setSelected(false);
    }
}
