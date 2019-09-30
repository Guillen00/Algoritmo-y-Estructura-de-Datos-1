package circuitsimulator;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/** Se añaden los nombres de las compuertas a la listas ,agrega la Jlist a un panel junto a 
 * botones y etiquetas informativas.
 * También se programa la selección en la lista para mostrar la compuerta de la lista 
 *
 * 
 */
public class ComponentsViewer extends JPanel {

    static JPanel preview;
    static Vector<String> listOfComponents = new Vector<>(0);
    static JList list;

    public ComponentsViewer() {
        preview = new JPanel() {};
        preview.setPreferredSize(new Dimension(100, 20));
        preview.setSize(100,20);
        this.add(preview);
        
        listOfComponents.add("And - 2");
        listOfComponents.add("And - 3");
        listOfComponents.add("Or - 2");
        listOfComponents.add("Or - 3");
        listOfComponents.add("Not");
        listOfComponents.add("XOR - 2");
        listOfComponents.add("XOR - 3");
        listOfComponents.add("XNOR - 2");
        listOfComponents.add("XNOR - 3");
        listOfComponents.add("NOR - 2");
        listOfComponents.add("NOR - 3");
        listOfComponents.add("NAND - 2");
        listOfComponents.add("NAND - 3");
        listOfComponents.add("Input");
        listOfComponents.add("Output");
        
        
        
        list = new JList(listOfComponents);
        JScrollPane pane = new JScrollPane(list);
        pane.setPreferredSize(new Dimension(50, this.getPreferredSize().height - 1));

        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String name = (String) list.getSelectedValue();
                    Mouse.setComponent(name);
                    Verticalbar.instance.setComponentActive();
                    preview.repaint();
                }
            }
        });


        JButton table = new JButton("Tabla Lógica");
        table.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                new TablaLogica();
            }
        });

        this.add(new JLabel("Lista de Componentes"));
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(table);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(pane);
    }
}
