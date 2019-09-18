
package inicio;

import static inicio.Imagen.seleccion;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;


public class AND extends javax.swing.JPanel{

    /*static int and;
    
     

    static int and (int x,int y) {
        int OUT = x*y;
        System.out.println(OUT);
        return OUT;
       }
    static int nand (int x,int y) {
        int OUT = x*y;
        if (OUT==0){
            System.out.println('1');
            return 1;}
        else{
            System.out.println('0');
            return 0;}
            
        }
    static int nor (int x,int y) {
        int OUT = x+y;
        if(OUT >0){
            System.out.println("0");
            return 0;
        }
            else{
            System.out.println("1");}
            return 1;
            
       }
    static int not (int x) {
        if(x == 0){
            System.out.println("1");
            return 1;
        }
            else{
            System.out.println("0");}
            return 0;
            
       }
    static int or (int x,int y) {
        int OUT = x+y;
        if(OUT >0){
            System.out.println("1");
            return 1;
        }
            else{
            System.out.println("0");}
            return 0;
            
       }
    static int xnor (int x,int y) {
        
        if (x==y){
            System.out.println('1');
            return 1;}
        else{
            System.out.println('0');
            return 0;}
            
        }
    static int xor (int x,int y) {
        
        if (x==y){
            System.out.println('0');
            return 0;}
        else{
            System.out.println('1');
            return 1;}
            
        } */
    public AND() {
        this.setSize(500, 800); //se selecciona el tamaño del panel
        
        }
        public void AND (Graphics g){
        
        Dimension height = getSize();

        //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
        String L = seleccion;
        
        if (seleccion != null){

        ImageIcon AND = new ImageIcon(getClass().getResource("/Imagenes/AND.png")); 

        //se dibuja la imagen que tenemos en el paquete Images //dentro de un panel

        g.drawImage(AND.getImage(), 5, 5, 50, 50, null);
        //grafico.setColor(java.awt.Color.BLACK);
        //grafico.drawLine(50, 30, 100, 30);
            }
        setOpaque(false);
        super.paintComponent(g);
    }

  

}

