
package com.teamsonia;
import java.util.*;


public abstract class Prism extends Shape {
    private double edgeLength; 

    public Prism(double height, double edgeLength) {
        this.height = height;
        this.edgeLength = edgeLength;
    }

    public double getEdgeLength() {
        return edgeLength;
    }

    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }
}

