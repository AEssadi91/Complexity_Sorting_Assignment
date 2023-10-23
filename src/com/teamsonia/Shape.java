
package com.teamsonia;

public abstract class Shape implements Comparable<Shape> {
    protected double height;

    public double getHeight() {
        return height;
    }

    public abstract double getVolume();
    public abstract double getBaseArea();

    @Override
    public int compareTo(Shape other) {
        return Double.compare(this.height, other.height);
    }

    @Override
    public String toString() {
        return String.format("Shape [Height = %.2f, Volume = %.2f, Base Area = %.2f]",
                getHeight(), getVolume(), getBaseArea());
    }
}
