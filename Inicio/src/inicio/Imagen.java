
package inicio;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Imagen extends javax.swing.JPanel {

        public static String seleccion;
        public Imagen() {
        this.setSize(500, 800); //se selecciona el tamaño del panel
        
        }

        //Se crea un método cuyo parámetro debe ser un objeto Graphics

    /**
     *
     * @param imp
     */
        public void Seleccion(String imp){
        Imagen.seleccion = imp;
        System.out.println(imp);
        }
        @Override
        public void paint(Graphics grafico){
        
        Dimension height = getSize();

        //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
        String L = seleccion;
        
        if (seleccion != null){
        ImageIcon Img = new ImageIcon(getClass().getResource("/Imagenes/"+Imagen.seleccion+".png")); 

        //se dibuja la imagen que tenemos en el paquete Images //dentro de un panel

        grafico.drawImage(Img.getImage(), 5, 5, 100, 100, null);

        setOpaque(false);
        super.paintComponent(grafico);}
        }}


