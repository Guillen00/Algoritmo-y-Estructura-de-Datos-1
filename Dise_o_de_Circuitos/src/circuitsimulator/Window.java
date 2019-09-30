package circuitsimulator;

import javax.swing.*;
import java.awt.*;

/**Es la principal para la interfase utilizando en patron de fachada ,mostrando solo una parte del código 
 * ocultando lo principal,esta clase conecta todas las clases que tienen elementos para mostrar en pantalla 
 *
 * 
 */
public class Window extends JFrame {
    static Sheet sheet;
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
   
}
