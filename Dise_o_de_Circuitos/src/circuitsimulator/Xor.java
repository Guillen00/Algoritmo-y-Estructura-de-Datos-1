package circuitsimulator;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;

/**Se crean las compuertas XOR con dos valores de medidas y como n ,numero de entradas
 * Se crean metodos que mandan la lógica de las compuertas y dibujan la compuerta .
 *
 * 
 */
public class Xor extends Component {

    Color shapeColor = Color.black;
    Area shape;
    int height = 50;
    int width = 50;
    boolean state = false;
    static BasicStroke stroke = new BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);

    public Xor(int x, int y, int n) {
        gateInputs = n;
        this.x = x;
        this.y = y;
        shape = new OrShape(x, y);

        outConnectors.add(new Connector(x + width, y + (height / 2), Types.Orientation.Horizontal, Types.IO.Output, this));

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

    Rectangle getBounds() {
        return new Rectangle(x - padding, y - padding, width + 2 * padding, height + 2 * padding);
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
        state = Logica.XOR(inConnectors);
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
        g2d.drawArc(x - 25, y, width / 2, height, -70, 140);
    }

    void delete() {
        Component.drawable.remove(this);
    }

    String getName() {
        return "XOR - " + gateInputs;
    }
}
