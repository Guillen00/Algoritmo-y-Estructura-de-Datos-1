
package circuitsimulator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;

/**Se crean las entradas que dan la informacion a las compuertas ,cambian datos de 1 a 0 y cambian de color 
 * Se configura la acción del objeto cuando se presiona con el mouse 
 *
 * 
 */
public class Input extends Component {

    Font font = new Font("Serif", Font.PLAIN, 32);
    String label = "0";
    Color shapeColor = Color.lightGray;
    Color labelColor = Color.WHITE;
    Rectangle shape;
    int height = 32;
    int width = 32;
    boolean state = false;

    public Input(int x, int y) {
        this.x = x;
        this.y = y;
        shape = new Rectangle(x, y, width, height);
        outConnectors.add(new Connector(x + width, y + (height / 2), Types.Orientation.Horizontal, Types.IO.Output, this));
        
    }

    Rectangle getShape() {
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
        if (state) {
            labelColor = Color.BLACK;
            state = false;
            label = "0";
        } else {
            labelColor = Color.white;
            state = true;
            label = "1";
        }
    }

    Boolean getState() {
        return state;
    }

    void onClick() {
        toggle();
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
        g2d.setColor(labelColor);
        g2d.setFont(font);
        g2d.drawString(label, x + 10, y + 25);

        g2d.setColor(colorBackup);
        g2d.setStroke(strokeBackup);
        g2d.translate(0, 0);
    }


    String getName() {
        return "Input";
    }
}
