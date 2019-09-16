/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicio;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author leona
 */
public class Mover extends JLabel implements MouseListener,MouseMotionListener{
    private  String Key ="";
    private Point posicion =new Point (0,0);
    private Dimension d =new Dimension(124,150);
    private Point start_lot;
    private Point start_drag;
    private Point offset;
    private int nuevo_x =1;
    private int nuevo_y =1;
    
    
    public Mover (String Key){
    this.Key = Key;
    this.setToolTipText(Key);
    this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    this.setSize(d);
    this.setPreferredSize(d);
    this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/AND.png")));
    this.setText("");
    this.setVisible(true);
    this.setLocation(posicion);
    this.addMouseListener(this);
    this.addMouseMotionListener(this);
    
    }

    Mover() {
        
    }
    
    public String getKey(){
        return Key;
    }
    
    /**
     *
     * @param Key
     */
    public void setKey(String Key){
    this.Key = Key;
    }
    @Override
    public void mouseClicked(MouseEvent me) {    
    }

    @Override
    public void mousePressed(MouseEvent me) {
    this.start_drag = getScreenLocation(me);
    this.start_lot =this.getLocation();
    }
    
    @Override
    public void mouseReleased(MouseEvent me) {
    nuevo_x = (this.getLocation().x);
    nuevo_y = (this.getLocation().y);
    this.setLocation(nuevo_x,nuevo_y);
    
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    this.setBorder(BorderFactory.createLineBorder(new java.awt.Color(204,0,51),1));
    }

    @Override
    public void mouseExited(MouseEvent me) {
    this.setBorder(null);
    }

    @Override
    public void mouseDragged(MouseEvent me) {
    Point current =this.getScreenLocation(me);
    offset = new Point((int)current.getX()-(int)start_drag.getX(),(int) start_drag.getY()-(int)current.getY());
    Point new_location = new Point((int)(this.start_lot.getX()+offset.getX()),(int)(this.start_lot.getY()+offset.getY()));
    this.setLocation(new_location);
    
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }
    
    private Point getScreenLocation(MouseEvent evt){
    Point cursor =evt.getPoint();
    Point target_location = this.getLocationOnScreen();
    return new Point ((int)(target_location.getX()+cursor.getX()),(int)(target_location.getY()+cursor.getY()));
    
    }
}
