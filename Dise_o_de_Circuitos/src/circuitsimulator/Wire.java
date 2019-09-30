package circuitsimulator;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.concurrent.CopyOnWriteArrayList;

/**Esta clase lo que realiza es el dibujar la linea de conección entre compuertas ,para esto conecta nodos 
 * y varia los puntos de una linea con forme se mueve el mouse.
 *
 * 
 */
public class Wire extends Component {

    static CopyOnWriteArrayList<Wire> allTheWires = new CopyOnWriteArrayList<>();
    static float width = 7;
    static Color color = Color.GRAY;
    static Color mouseOverColor = Color.red;
    static BasicStroke stroke = new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
    Node from;
    Node to;
    GeneralPath polyline;
    int[] x;
    int[] y;
    int npoints;

    public Wire(int[] _x, int[] _y, int _npoints, Node n1, Node n2) {
        from = n1;
        to = n2;
        n1.connectedTo.add(n2);
        n2.connectedTo.add(n1);
        npoints = _npoints;
        x = new int[npoints];
        y = new int[npoints];
        for (int i = 0; i < npoints; i++) {
            x[i] = _x[i];
            y[i] = _y[i];
        }
        x[0] = n1.x4ext;
        y[0] = n1.y4ext;
        x[npoints - 2] = n2.x4ext;
        y[npoints - 2] = n2.y4ext;
        polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, npoints);
        polyline.moveTo(x[0], y[0]);
        for (int index = 1; index < npoints; index++) {
            polyline.lineTo(x[index], y[index]);
        };
        allTheWires.add(this);
    }

    public Wire(Node c1, Node c2) {
        from = c1;
        to = c2;
    }

    public void wireUnderProduction() {
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(color);

        g2d.setStroke(stroke);
        g2d.draw(polyline);
    }

    public static void DrawAll(Graphics2D g2d) {
        for (Wire wire : allTheWires) {
            wire.draw(g2d);
        }
    }

    String getName() {
        return "Wire";
    }
}
