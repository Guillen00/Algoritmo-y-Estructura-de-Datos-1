
package inicio;

import static inicio.Nodo.d;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;

public class Imagen extends javax.swing.JPanel {
        public static ArrayList<Object> componentes = new ArrayList<>();
        public static String seleccion;
        private Vector<Nodo> vectorNodos;
        
        public Imagen() {
        this.setSize(500, 800); //se selecciona el tamaño del panel
        
        }

        //Se crea un método cuyo parámetro debe ser un objeto Graphics

    /**
     *
     * @param imp
     * @return 
     */ 
        public ArrayList<Object> lista(){
        return componentes;
        }
        public void Seleccion(String imp){
        Imagen.seleccion = imp;
        System.out.println("SELECTION "+imp);
        }
        @Override
        public void paint(Graphics g){
        Graphics2D grafico = (Graphics2D) g;
        Dimension height = getSize();

        //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
        String L = seleccion;
        
        this.vectorNodos =new Vector<>();
        
        
        if (seleccion != null){
            System.out.println("SELECTION 1 "+seleccion);
        if ("AND".equals(seleccion)){
            this.vectorNodos =new Vector<>();
            ImageIcon Img1 = new ImageIcon(getClass().getResource("/Imagenes/AND.png")); 
            grafico.drawImage(Img1.getImage(), 30, 0, 50, 50, null);
            grafico.drawLine(10, 17, 30, 17);
            grafico.drawLine(10, 33, 30, 33);
            grafico.drawLine(80, 25, 100, 25);
            grafico.drawOval(5 - d/2, 17 - d/2, d, d);
            vectorNodos.add(new Nodo(5,17));
            grafico.drawOval(5 - d/2, 33 - d/2, d, d);
            vectorNodos.add(new Nodo(5,33));
            grafico.drawOval(105 - d/2, 25 - d/2, d, d);
            vectorNodos.add(new Nodo(105,25));
        }
        if ("NOT".equals(seleccion)){
            this.vectorNodos =new Vector<>();
            ImageIcon Img1 = new ImageIcon(getClass().getResource("/Imagenes/NOT.png")); 
            grafico.drawImage(Img1.getImage(), 30, 0, 50, 50, null);
            grafico.drawLine(15, 25, 30, 25);
            grafico.drawLine(80, 25, 100, 25);
            grafico.drawOval(10 - d/2, 25 - d/2, d, d);
            vectorNodos.add(new Nodo(5,17));
            grafico.drawOval(105 - d/2, 25 - d/2, d, d);
            vectorNodos.add(new Nodo(105,25));
            
        }
        //se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
        else{
            ImageIcon Img = new ImageIcon(getClass().getResource("/Imagenes/"+Imagen.seleccion+".png"));
            grafico.drawImage(Img.getImage(), 30, 0, 50, 50, null);
            grafico.drawLine(10, 17, 30, 17);
            grafico.drawLine(10, 33, 30, 33);
            grafico.drawLine(80, 25, 100, 25);
            grafico.drawOval(5 - d/2, 17 - d/2, d, d);
            vectorNodos.add(new Nodo(5,17));
            grafico.drawOval(5 - d/2, 33 - d/2, d, d);
            vectorNodos.add(new Nodo(5,33));
            grafico.drawOval(105 - d/2, 25 - d/2, d, d);
            vectorNodos.add(new Nodo(105,25));
        }
      
        System.out.println(vectorNodos);

        //grafico.setColor(java.awt.Color.BLACK);
        //grafico.drawLine(50, 30, 100, 30);
        //Img.paintIcon(this, grafico, 5, 5);
            
        setOpaque(false);
        super.paintComponent(grafico);
        
            
        //componentes.add(Img);
        }
        
    }

}


