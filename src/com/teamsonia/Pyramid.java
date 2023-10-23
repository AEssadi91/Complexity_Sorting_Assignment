package com.teamsonia;

public class Pyramid extends Shape {
    private double baseWidth;
    private double height;

    public Pyramid(double baseWidth, double height) {
        this.baseWidth = baseWidth;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return (1.0 / 3) * Math.pow(baseWidth, 2) * height;
    }

    @Override
    public double getBaseArea() {
        return Math.pow(baseWidth, 2);
    }

    @Override
    public String toString() {
        return String.format("Pyramid [Base Width = %.2f, Height = %.2f, Volume = %.2f, Base Area = %.2f]",
                baseWidth, height, getVolume(), getBaseArea());
    }
}
