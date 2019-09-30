package circuitsimulator;

import java.awt.Point;

/** Contiene en su mayoria las acciones que adquiere el mouse desde lo seleccionado ,localización
 * y en donde realizo un clic
 *
 * 
 */
public class Mouse {

    static String component = null;
    static Point MouseLocation = new Point(0, 0);
    static Point ClickLocation = new Point(0, 0);
    static Mode mode = Mode.Component;
    static State state = State.resting;
    static Point DeleteLocation = new Point(-50, -50);

    public enum State {

        placingComponent,
        resting
    };

    public enum Mode {

        Track,
        Component
        
    };

    static void setComponent(String in) {
        component = in;
    }

    static String selectedComponent() {
        return component;
    }

    static void setMouseLocation(Point p) {
        MouseLocation = p;
    }

    static void setMouseLocaiton(int x, int y) {
        MouseLocation.setLocation(x, y);
    }

    static void setClickLocation(int x, int y) {
        ClickLocation.setLocation(x, y);
    }

    static void setClockLocation(Point p) {
        ClickLocation = p;
    }

    static int getClickX() {
        return (int) ClickLocation.getX();
    }

    static int getClickY() {
        return (int) ClickLocation.getY();
    }

    static int getLocX() {
        return (int) MouseLocation.getX();
    }

    static int getLocY() {
        return (int) MouseLocation.getY();
    }

    static void setMode(Mode m) {
        mode = m;
    }

    static Mode getMode() {
        return mode;
    }

    
}
