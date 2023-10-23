
package com.teamsonia;
import java.util.*;


public class OctagonalPrism extends Prism {
    public OctagonalPrism(double height, double edgeLength) {
        super(height, edgeLength);
    }

    @Override
    public double getBaseArea() {
        return 2 * (1 + Math.sqrt(2)) * Math.pow(height, 2);
    }

    @Override
    public String toString() {
        return String.format("OctagonalPrism [Height = %.2f, Edge Length = %.2f, Volume = %.2f, Base Area = %.2f]",
                height, getEdgeLength(), getVolume(), getBaseArea());
    }
}
