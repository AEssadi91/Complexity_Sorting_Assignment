
package com.teamsonia;


public class PentagonalPrism extends Prism {
    public PentagonalPrism(double height, double edgeLength) {
        super(height, edgeLength);
    }

    @Override
    public double getBaseArea() {
        return (5.0 * Math.pow(getEdgeLength(), 2)) / (4.0 * Math.tan(Math.PI / 5));
    }

    @Override
    public String toString() {
        return String.format("PentagonalPrism [Height = %.2f, Edge Length = %.2f, Volume = %.2f, Base Area = %.2f]",
                height, getEdgeLength(), getVolume(), getBaseArea());
    }
}
