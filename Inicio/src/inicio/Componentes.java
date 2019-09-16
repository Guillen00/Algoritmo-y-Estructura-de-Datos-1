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
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Hassan
 */
public abstract class Componentes {

    int x, y;

    int tx = 0, ty = 0;
    static Boolean pullState = false;
    ArrayList<Componentes> ejecutable = new ArrayList<>();
    ArrayList<Conectores> inConnectors = new ArrayList<>();
    ArrayList<Conectores> outConnectors = new ArrayList<>();
// Creamos listas que contengan las enttradas y salidas 
    static CopyOnWriteArrayList<Componentes> drawable = new CopyOnWriteArrayList<>();
    int gateInputs = 999;
    int padding = 8;

    public Componentes() {
    }

    abstract void draw(Graphics2D g2d);

    void drawConnectors(Graphics2D g2d) {
        drawOutConnectors(g2d);
        drawInConnectors(g2d);
        //Dibuja los conectores
    }

    void drawOutConnectors(Graphics2D g2d) {
        outConnectors.forEach((con) -> {
            con.draw(g2d);
        });
    }

    void drawInConnectors(Graphics2D g2d) {
        inConnectors.forEach((con) -> {
            con.draw(g2d);
        });
    }

    /*void delete() {
        Wire.delete(this.inConnectors, this.outConnectors);
        Componentes.drawable.remove(this);
        Mouse.resetDeleteLocation();
    }*/

    String getName() {
        return null;
    }

    Shape getShape() {
        return null;
    }

//    abstract Rectangle getBounds();
//    abstract void onClick();
    Boolean getState() {
        return null;
    }

    void onClick() {
    }
}
