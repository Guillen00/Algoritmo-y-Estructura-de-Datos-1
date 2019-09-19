/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicio;


/**
 *
 * @author leona
 */
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.JPanel;

/**
 *
 * @author leona
 */
public class Conectores extends JPanel implements MouseListener {
    private Vector<Nodo> vectorNodos;
    private Vector<Enlace> vectorEnlaces;
    private Point p1,p2;
            
    public Conectores (){
        this.vectorNodos =new Vector<>();
        this.vectorEnlaces =new Vector<>();
        this.addMouseListener(this);
    }
    @Override
    public void paint(Graphics g){
        for (Nodo nodos : vectorNodos){
        nodos.pintar(g);}
        for(Enlace enlace :vectorEnlaces){
        enlace.pintar(g);}
    }
    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if(me.getButton() ==MouseEvent.BUTTON1){
            for(Nodo nodo :vectorNodos){
                 System.out.println(nodo.getX());
                 System.out.println(nodo.getX());
                if(new Rectangle(nodo.getX()-Nodo.d/2,nodo.getY()-Nodo.d/2,Nodo.d,Nodo.d).contains(me.getPoint())){
                    if(p1 ==null)
                        p1 = new Point(nodo.getX(),nodo.getY());
                    else{
                        p2 = new Point(nodo.getX(),nodo.getY());
                        this.vectorEnlaces.add(new Enlace(p1.x,p1.y,p2.x,p2.y));
                        repaint();
                        p1= null;
                        p2= null;
                    }
            }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }}
    

