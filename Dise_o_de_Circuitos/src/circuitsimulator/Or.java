package circuitsimulator;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;

/**e crean las compuertas OR con dos valores de medidas y como n ,numero de entradas 
 * Se crean metodos que mandan la lógica de las compuertas y dibujan la compuerta .
 *
 * 
 */
public class Or extends Component {

    Area shape;
    int height = 50;
    int width = 50;
    Color shapeColor = Color.DARK_GRAY;
    boolean state = false;
    static BasicStroke stroke = new BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);


    public Or(int x, int y, int n) {
        gateInputs = n;
        this.x = x;
        this.y = y;
        shape = new OrShape(x, y);

        outConnectors.add(new Connector(x + width, y + (height / 2), Types.Orientation.Horizontal, Types.IO.Output, this));
        int number = n;
        int gap = height / (number + 1);
        int yt = y;
        for (int i = 0; i < number; i++) {
            yt += gap;
            inConnectors.add(new Connector(x + 5, yt, Types.Orientation.Horizontal, Types.Position.LEFT, Types.IO.Input, this));
        }
    }

    Area getShape() {
        return shape;
    }

    Rectangle getBounds() {
        return new Rectangle(x - padding, y - padding, width + 2 * padding, height + 2 * padding);
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
        state = Logica.OR(inConnectors);
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
    }

    String getName() {
        return "Or - " + gateInputs;
    }
}
