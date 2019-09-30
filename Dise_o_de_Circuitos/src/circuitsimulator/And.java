package circuitsimulator;

import circuitsimulator.Component;
import java.awt.*;
import java.awt.geom.Area;

/**Se crean las compuertas AND con dos valores de medidas y como n ,numero de entradas ,envia a una lista donde se 
    envia a otra función que dibuja la compuerta con sus respectivas entradas y salidas.
 * Se crean metodos que mandan la lógica de las compuertas y dibujan la compuerta .
 * 
 */
public class And extends Component {

    Color shapeColor = Color.black;
    Area shape;
    int height = 50;
    int width = 50;
    boolean state = false;
    static BasicStroke stroke = new BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);

    public And(int x, int y, int n) {
        gateInputs=n;
        this.x = x;
        this.y = y;
        shape = new AndShape(x, y);

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
    
    Rectangle getBounds(){
        return new Rectangle(x-padding,y-padding,width+2*padding,height+2*padding);
    }


    Color getShapeColor() {
        return shapeColor;
    }

    @Override
    Boolean getState() {
        System.out.println( Logica.AND(inConnectors));
        return Logica.AND(inConnectors);
        
    }

    void draw(Graphics2D g2d) {
        
        g2d.translate(tx, ty);
        drawConnectors(g2d);
        g2d.setColor(shapeColor);
        g2d.setStroke(stroke);
        g2d.draw(shape);
    }
    
    String getName(){
        return "And - "+gateInputs;
    }
}
