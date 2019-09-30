package circuitsimulator;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

/**Se crean las compuertas XNOR con dos valores de medidas y como n ,numero de entradas
 * Se crean metodos que mandan la lógica de las compuertas y dibujan la compuerta .
 *
 * 
 */
public class Xnor extends Component {

    Color shapeColor = Color.black;
    Area shape;
    int height = 50;
    int width = 50;
    boolean state = false;
    static BasicStroke stroke = new BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);

    public Xnor(int x, int y, int n) {
        gateInputs = n;
        this.x = x;
        this.y = y;

        shape = new OrShape(x, y);
        shape.add(new Area(new Ellipse2D.Double(x + width, y - 5 + width / 2, 10, 10)));

        outConnectors.add(new Connector(x + width + 10, y + (height / 2), Types.Orientation.Horizontal, Types.IO.Output, this));

        int gap = height / (n + 1);
        int yt = y;
        for (int i = 0; i < n; i++) {
            yt += gap;
            inConnectors.add(new Connector(x, yt, Types.Orientation.Horizontal, Types.Position.LEFT, Types.IO.Input, this));
        }
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
        state = Logica.XNOR(inConnectors);
    }

    void draw(Graphics2D g2d) {
        
        g2d.translate(tx, ty);
        drawConnectors(g2d);
        g2d.setColor(shapeColor);
        g2d.setStroke(stroke);
        g2d.draw(shape);
        g2d.drawArc(x - 25, y, width / 2, height, -70, 140);
        
       
//        g2d.translate(0, 0);
    }

    String getName() {
        return "XNOR - " + gateInputs;
    }

    Area getShape() {
        return shape;
    }

    Rectangle getBounds() {
        return new Rectangle(x - padding, y - padding, width + 2 * padding, height + 2 * padding);
    }
}
