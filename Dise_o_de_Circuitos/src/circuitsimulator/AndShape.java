/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package circuitsimulator;

import java.awt.*;
import java.awt.geom.*;

/**Se crean áreas para las AND  a utilizar ,en la que se dibujará la compuerta 
 * 
 */
public class AndShape extends Area {

    int width = 50;
    int height = 50;
    Rectangle rectShape;
    Ellipse2D.Double ellipseShape;
    int x;
    int y;
    static Area preview = null;

    public AndShape(int x, int y) {
        this.x = x;
        this.y = y;
        ellipseShape = new Ellipse2D.Double(x, y, width, height);
        rectShape = new Rectangle(x, y, width / 2, height);
        this.add(new Area(rectShape));
        this.add(new Area(ellipseShape));
    }

    
}
