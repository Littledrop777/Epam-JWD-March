package com.epam.jwd.model;

import java.util.Arrays;

public abstract class Figure {

    private final Point[] points;

    protected Figure(Point[] points) {
        this.points = points;
    }

    public Point[] getPoints() {
        return points;
    }

    public Point getPoint(int index) {
        return points[index];
    }

    public String toString() {
        return "{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
}
