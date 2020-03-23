package sample;

import java.awt.Polygon;

public class RegularPolygon extends Polygon {
    public RegularPolygon(int x0, int y0, int radius, int sides) {
        double alpha = 6.283185307179586D / (double)sides;

        for(int i = 0; i < sides; ++i) {
            double x = (double)x0 + (double)radius * Math.cos(alpha * (double)i);
            double y = (double)y0 + (double)radius * Math.sin(alpha * (double)i);
            this.addPoint((int)x, (int)y);
        }

    }
}
