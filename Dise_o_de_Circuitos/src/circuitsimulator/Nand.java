/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package circuitsimulator;

import circuitsimulator.Component;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

/**
 *
 * @author Hassan
 */
public class Nand extends Component {

    Color shapeColor = Color.black;
    Rectangle rectShape;
    Ellipse2D.Double ellipseShape;
    Area shape;
    int height = 50;
    int width = 50;
    Boolean state = false;
    static BasicStroke stroke = new BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);


    public Nand(int x, int y, int n) {
        gateInputs = n;
        this.x = x;
        this.y = y;
        shape = new AndShape(x, y);
        shape.add(new Area(new Ellipse2D.Double(x + width, y - 5 + width / 2, 10, 10)));


        outConnectors.add(new Connector(x + width + 10, y + (height / 2), Types.Orientation.Horizontal, Types.IO.Output, this));

        int gap = height / (n + 1);
        int yt = y;
        for (int i = 0; i < n; i++) {
            yt += gap;
            inConnectors.add(new Connector(x, yt, Types.Orientation.Horizontal, Types.Position.LEFT, Types.IO.Input, this));
        }
    }

    Area getShape() {
        return shape;
    }

    Color getShapeColor() {
        return shapeColor;
    }

    synchronized Boolean getState() {
        Thread stateUpdater = new Thread() {
            public void run() {
                updateState();
            }
        };
        try {
            return state;
        } finally {
            stateUpdater.start();
        }
    }

    void updateState() {
        state = Logica.NAND(inConnectors);
    }
    Rectangle getBounds(){
        return new Rectangle(x-padding,y-padding,width+2*padding,height+2*padding);
    }
    
    void draw(Graphics2D g2d) {
        if (getBounds().contains(Mouse.DeleteLocation)) {
            delete();
        }
        g2d.translate(tx, ty);
        drawConnectors(g2d);
        g2d.setColor(shapeColor);
        g2d.setStroke(stroke);
        g2d.draw(shape);
//        g2d.translate(0, 0);
    }

    void delete() {
        Component.drawable.remove(this);
    }

    String getName() {
        return "NAND - " + gateInputs;
    }
}
