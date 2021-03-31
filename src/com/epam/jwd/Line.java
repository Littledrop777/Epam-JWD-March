package com.epam.jwd;

import java.util.Objects;

public class Line implements Shape {
    private Point a;
    private Point b;

    public Line(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean isShape() {
        return !a.equals(b);
    }

    public static double calcDistance(Point a, Point b) {
        double result;
        double oneSide;
        double secondSide;

        oneSide = Math.pow((b.getX() - a.getX()), 2);
        secondSide = Math.pow((b.getY() - a.getY()), 2);
        result = Math.sqrt(oneSide + secondSide);

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(a, line.a) && Objects.equals(b, line.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        return "Line{" +
                "a=(" + a.getX() + ", " + a.getY() +
                "), b=(" + b.getX() + ", " + b.getY()+
                ")}";
    }
}
