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

/**
 *
 * @author leona
 */
public class Enlace {
    private int x1,y1,x2,y2;
    public Enlace(int x1,int y1,int x2,int y2){
    this.x1=x1;
    this.y1=y1;
    this.x2=x2;
    this.y2=y2;
    }
    public void pintar(Graphics g){
        g.drawLine(x1, y1, x2, y2);   
    }
    public int getX1(){
        return x1;
    }
    public void setX1(int x1){
        this.x1 = x1;
        
    }
    public int getY1(){
        return y1;
    }
    public void setY1(int y1){
        this.y1 = y1;
        
    }
    
    } 