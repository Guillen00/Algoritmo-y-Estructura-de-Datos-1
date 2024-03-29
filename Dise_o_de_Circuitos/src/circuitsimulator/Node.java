package circuitsimulator;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

/**Se crean los nodos ,se dibujan se añaden a lista de nodos,se utilizan para las conexiones y uniones 
 * de compuertas 
*    
 *
 * 
 */
public class Node extends Component {

    static ArrayList<Node> allTheNodes = new ArrayList<>();
    static int diameter = 12;
    static Color outlineColor = Color.RED;
    static int outlinePadding = 6;
    static float dash[] = {4.0f};
    static Stroke outlineStroke = new BasicStroke(1.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f);
    Rectangle outline;
    static Color color = Color.black;
    Ellipse2D.Double shape;
    int x;
    int y;
    int x4ext;
    int y4ext;
    ArrayList<Node> connectedTo = new ArrayList<>();
    Types.IO type;
    Connector con;
    Boolean state;

    public Node(int _x, int _y, Connector con, Types.IO type) {
        x4ext = _x;
        y4ext = _y;
        this.x = _x - diameter / 2;
        this.y = _y - diameter / 2;
        shape = new Ellipse2D.Double(x, y, diameter, diameter);
        outline = new Rectangle(x - outlinePadding / 2, y - outlinePadding / 2, diameter + outlinePadding, diameter + outlinePadding);
        this.type = type;
        this.con = con;
        allTheNodes.add(this);
    }

    public void draw(Graphics2D g2d) {
        if (getBounds().contains(Mouse.MouseLocation)) {
            drawOutline(g2d);
        }
        g2d.setColor(color);
        g2d.fill(shape);
    }

    public void drawOutline(Graphics2D g2d) {
        g2d.setColor(outlineColor);
        g2d.setStroke(outlineStroke);
        g2d.draw(outline);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, diameter, diameter);
    }

    public Boolean getState() {
        updateState();
        return state;
    }

    void updateState() {
        if (type == Types.IO.Output) {
            state = con.getState();
            return;
        }
        for (Node n : connectedTo) {
            if (n.type == Types.IO.Output) {
                state = n.getState();
                System.out.println(state+"  nodo|   ");
                
                
            }
        }
        for (Node n : connectedTo) {
            if (n.type == Types.IO.Input) {
                state = n.state;
                return;
            }
        }
    }
 

    @Override
    String getName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
