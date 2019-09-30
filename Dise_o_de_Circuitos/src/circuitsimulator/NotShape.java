package circuitsimulator;

import java.awt.*;
import java.awt.geom.*;

/**Se crean áreas para las NOT a utilizar ,en la que se dibujará la compuerta 
 *
 * 
 */
public class NotShape extends Area {

    int width = 40;
    int height = 20;
    Polygon triangle;
    int x, y;

    public NotShape(int x, int y) {
        this.x = x;
        this.y = y;
        triangle = new Polygon();
        triangle.addPoint(x + width, y + height);
        triangle.addPoint(x, y + 2 * height);
        triangle.addPoint(x, y);
        triangle.addPoint(x + width, y + height);
        this.add(new Area(triangle));
    }
}
