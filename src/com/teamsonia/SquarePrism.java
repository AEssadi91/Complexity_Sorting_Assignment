
package com.teamsonia;

public class SquarePrism extends Prism {
    public SquarePrism(double height, double edgeLength) {
        super(height, edgeLength);
    }

    @Override
    public double getBaseArea() {
        return Math.pow(getEdgeLength(), 2);
    }

    @Override
    public String toString() {
        return String.format("SquarePrism [Height = %.2f, Edge Length = %.2f, Volume = %.2f, Base Area = %.2f]",
                height, getEdgeLength(), getVolume(), getBaseArea());
    }
}

