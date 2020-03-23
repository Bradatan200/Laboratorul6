package sample;

import java.awt.geom.Ellipse2D.Double;

class Shape extends Double {
    public Shape(double x0, double y0, double radius) {
        super(x0 - radius / 2.0D, y0 - radius / 2.0D, radius, radius);
    }
}
