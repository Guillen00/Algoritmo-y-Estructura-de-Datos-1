
package circuitsimulator;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/** Crea una nueva ventana al accionar un boton y esta ventana contiene una tabla de la verdad ,
 * contiene todas las combinaciones posibles para el número de compuertas puestas en el panel  
 *
 * 
 */
public class TablaLogica extends JFrame {
    static String title = "Tabla Lógica";
    static Connector CONNECTOR;
    static CircuitSimulator sim;
    static Table table;
    JPanel left;
    JPanel center;
    JPanel right;
    
    public TablaLogica(){
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(700, 700));
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        this.setVisible(true);
        this.setResizable(false);
        
        Table table = new Table();
        int y = CircuitSimulator.getcountIn();
        
        table.listabinaria(y/2);
        System.out.println(table.getList());
        center = new JPanel();
        right = new JPanel() {
        };
        this.add(addTable());      
       
    }

    JScrollPane addTable() {
        TableModel model = new TableModel1();
        final JTable table1 = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table1);
        

        return scrollPane;
    }
    }
  
    

