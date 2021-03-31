package com.epam.jwd.model;

import java.util.Objects;

public class Triangle implements Figure {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double square() {
        double result;
        // s = Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)) / 2;
        result = Math.abs((b.getX() - a.getX()) * (c.getY() - a.getY()) - (c.getX() - a.getX()) * (b.getY() - a.getY())) / 2;
        return result;
    }

    @Override
    public boolean isExist() {
        return square()!=0;
    }

    @Override
    public boolean isShape() {
        return a.equals(b) || b.equals(c) || a.equals(c);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(a, triangle.a) && Objects.equals(b, triangle.b) && Objects.equals(c, triangle.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=(" + a.getX() + ", " + a.getY() +
                "), b=(" + b.getX() + ", " + b.getY() +
                "), c=(" + c.getX() + ", " + c.getY() +
                ")}";
    }
}
