package circuitsimulator;

import circuitsimulator.Types.IO;
import circuitsimulator.Types.Orientation;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;

/** Se crean las output ,dibuja la terminal de los circuitos ,dependiendo de como tranformen las compuertas 
 * los datos ,los que llegan a la terminal será el mostrado
 *
 * 
 */
public class Output extends Component {

    Font font = new Font("Serif", Font.PLAIN, 30);
    String label = "0";
    Color shapeColor = Color.lightGray;
    Color labelColor = Color.WHITE;
    Ellipse2D shape;
    int height = 32;
    int width = 32;
    Boolean state = null;

    public Output(int x, int y) {
        this.x = x;
        this.y = y;
        shape = new Ellipse2D.Double(x, y, width, height);
        inConnectors.add(new Connector(x, y + (height / 2), Orientation.Horizontal, Types.Position.LEFT, IO.Input, this));
    }

    Ellipse2D getShape() {
        return shape;
    }

    String getLabel() {
        return label;
    }

    Font getFont() {
        return font;
    }

    Color getShapeColor() {
        return shapeColor;
    }

    Color getLabelColor() {
        return labelColor;
    }

    void toggle() {
    }

    void updateState() {
        state = inConnectors.get(0).getState();
        System.out.println(state+"  output|   ");
        if (state == null) {
            labelColor = Color.RED;
            state = false;
            label = "?";
        } else if (state == true) {
            labelColor = Color.WHITE;
            state = true;
            label = "1";
        } else {
            labelColor = Color.BLACK;
            state = false;
            label = "0";
        }
    }

    Rectangle getBounds() {
        return new Rectangle(x - padding, y - padding, width + 2 * padding, height + 2 * padding);
    }

    void draw(Graphics2D g2d) {
        
        g2d.translate(tx, ty);
        Color colorBackup = g2d.getColor();
        Stroke strokeBackup = g2d.getStroke();

        drawConnectors(g2d);

        g2d.setColor(shapeColor);
        g2d.fill(shape);
        updateState();
        g2d.setColor(labelColor);
        g2d.setFont(font);
        g2d.drawString(label, x + 10, y + 25);

        g2d.setColor(colorBackup);
        g2d.setStroke(strokeBackup);
        g2d.translate(0, 0);
    }

    String getName() {
        return "Output";
    }
}
