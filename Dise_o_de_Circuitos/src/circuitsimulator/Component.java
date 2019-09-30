package circuitsimulator;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**Dibuja conectores ,entradas y salidas ,contienen las listas donde se almacenan los datos de las 
 * compuertas
 * 
 * 
 */
public abstract class Component {

    int x, y;
    int tx = 0, ty = 0;
    static Boolean pullState = false;
    ArrayList<Component> runnable = new ArrayList<>();
    ArrayList<Connector> inConnectors = new ArrayList<>();
    ArrayList<Connector> outConnectors = new ArrayList<>();
    static CopyOnWriteArrayList<Component> drawable = new CopyOnWriteArrayList<>();
    int gateInputs = 999;
    int padding = 8;

    public Component() {
    }

    abstract void draw(Graphics2D g2d);

    void drawConnectors(Graphics2D g2d) {
        drawOutConnectors(g2d);
        drawInConnectors(g2d);
    }

    void drawOutConnectors(Graphics2D g2d) {
        for (Connector con : outConnectors) {
            con.draw(g2d);
        }
    }

    void drawInConnectors(Graphics2D g2d) {
        for (Connector con : inConnectors) {
            con.draw(g2d);
        }
    }

    void delete() {
        Component.drawable.remove(this);
        Mouse.resetDeleteLocation();
    }

    String getName() {
        return null;
    }

    Shape getShape() {
        return null;
    }

    Boolean getState() {
        return null;
    }
    
    Boolean setState(boolean valor) {
        boolean valor1 = inConnectors.get(0).setState(valor);
        return valor1;
    }

    void onClick() {
    }
}
