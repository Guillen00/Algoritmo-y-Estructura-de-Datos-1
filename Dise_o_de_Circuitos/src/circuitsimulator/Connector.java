
package circuitsimulator;

import java.awt.*;
import java.awt.geom.*;
import circuitsimulator.Types.*;
import java.util.ArrayList;

/** Crea el conector ya sea entrada o salida depende de esta entra a un metodo diferente 
 * mantiene el estado de la compuerta según el ususario haya puesto y se actualiza constantemente 
 * 
 *
 * 
 */
public class Connector extends Component {

    ArrayList<Wire> wires = new ArrayList<>();
    static float width = 5;
    static int length = 20;
    static Color color = Color.black;
    int x;
    int y;
    Types.IO type;
    Line2D.Double shape;
    BasicStroke stroke;
    Node node;
    Boolean state = null;
    Component comp;
    

    public Connector(int x, int y, Orientation _orientation, Types.IO type) {
        this.x = x;
        this.y = y;
        node = new Node(x + length, y, this, type);
        this.type = type;
        stroke = new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        shape = new Line2D.Double(x, y, x + length, y);
    }

    public Connector(int x, int y, Orientation _orientation, Types.IO type, Component c) {
        comp = c;
        this.x = x;
        this.y = y;
        node = new Node(x + length, y, this, type);
        this.type = type;
        stroke = new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        shape = new Line2D.Double(x, y, x + length, y);
    }

    public Connector(int x, int y, Orientation _orientation, Types.Position pos, Types.IO type, Component c) {
        comp = c;
        this.x = x;
        this.y = y;
        this.type = type;
        stroke = new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        switch (pos) {
            case LEFT:
                shape = new Line2D.Double(x-length, y, x, y);
                node = new Node(x - length, y, this, type);
                break;
            case RIGHT:
                shape = new Line2D.Double(x, y, x + length, y);
                node = new Node(x + length, y, this, type);
                break;
        }
    }

    void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.setStroke(stroke);
        g2d.draw(shape);
        node.draw(g2d);
    }

    Boolean getState() {
        if (type == Types.IO.Input) {
            updateState();
            return state;
        } else {
            return comp.getState();
        }

    }

    void setState(Boolean in) {
        state = in;
    }

    void updateState() {
        state = node.getState();
        System.out.println(state+"  connector|   ");
    }
        String getName(){
        return "Connector";
    }
}
