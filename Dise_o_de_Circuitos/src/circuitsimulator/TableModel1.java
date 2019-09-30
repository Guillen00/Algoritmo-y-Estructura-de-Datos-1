package circuitsimulator;


import javax.swing.table.AbstractTableModel;

/**Contiene información de la tabla ,como columnas y filas ,lee la matriz en la que anteriormente se guardaron 
 * los datos y da tamaños de filas y columnas para acomodar la tabla
 *
 * 
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