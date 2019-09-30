
package circuitsimulator;


import java.awt.Graphics2D;

/** Tiene metodos que su funciones son, uno recibe un número decimal el cual es la cantidad de posibles 
 * combinaciones y escribe todos los números binarios hasta llegar a las n posibilidades ,otra agarra ese 
 * string y lo compara con el número de posibles combinaciones para que todos tengan la misma cantidad de 
 * digitos y los añade a una matriz 
 *
 * 
 */
public class Table extends Component {
    static Component con;
    boolean chi;
    static TablaLogica tabla;
    static String [][] data;
    
    public Table(){
        
        
    }
    @Override
    void draw(Graphics2D g2d) {
      
    }
    
    String[][] listabinaria(int x){
        int y = ((int) Math.pow(2, x))-1;
        int z =0;
        data = new String [y+1][y+1];
        while (z<y+1){
            data[z][0] = (String)space(Binario(z),y);
            System.out.println(space(Binario(z),y));
        z++;
        }
        
        return data;
    }
    
    String Binario (int y){
    String binario = "";
        if (y > 0) {
            while (y > 0) {
                if (y % 2 == 0) {
                    binario = "0" + binario;
                } else {
                    binario = "1" + binario;
                }
                y = (int) y / 2;
            }
        } else if (y == 0) {
            binario = "0";
        }
        
        return binario;
    }
    String space(String v,int y){
        int u=v.length();
        int r = Binario(y).length();
        
        while(u<r){
            v ="0"+ v;
            u=v.length();
        }
        return v;
    }
    String[][] getList(){
    return data;
    }
}
