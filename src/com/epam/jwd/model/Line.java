package com.epam.jwd.model;

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
        return a.equals(b);
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
