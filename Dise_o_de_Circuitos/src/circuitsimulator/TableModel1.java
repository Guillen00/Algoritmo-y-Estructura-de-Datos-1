/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package circuitsimulator;


import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Hassan
 */
public class TableModel1 extends AbstractTableModel {

    String[] columnNames = {
        "Entradas",
        "Salidas"
        
    };
        String [][] data = Table.data;
    
        public TableModel1() {
System.out.println("Tabla");
    }

    @Override
    public int getRowCount() {
        return data.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }
    
    @Override
    
    public int getColumnCount() {
        return columnNames.length;
    }

    
    
    public String getColumnName(int col) {
        return columnNames[col];
    }
}