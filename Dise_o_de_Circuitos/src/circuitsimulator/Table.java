/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuitsimulator;


import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author leona
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
            //combination.add((String)space(Binario(z),y));
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
