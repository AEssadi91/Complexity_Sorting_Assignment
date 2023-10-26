package com.teamsonia;

public class TriangularPrism extends Prism {
    public TriangularPrism(double height, double edgeLength) {
        super(height, edgeLength);
    }

    @Override
    public double getBaseArea() {
        return (Math.sqrt(3) / 4) * Math.pow(getEdgeLength(), 2);
    }

    @Override
    public String toString() {
        return String.format("TriangularPrism [Height = %.2f, Edge Length = %.2f, Volume = %.2f, Base Area = %.2f]",
                height, getEdgeLength(), getVolume(), getBaseArea());
    }
}
