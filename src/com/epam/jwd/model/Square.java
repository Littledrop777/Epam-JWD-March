package com.epam.jwd.model;

import com.epam.jwd.service.Service;

import java.util.Objects;

public class Square implements Figure {
    private final Point a;
    private final Point b;
    private final Point c;
    private final Point d;

    public Square(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public boolean isShape() {
        return a.equals(b) || b.equals(c) || c.equals(d) || a.equals(d);
    }

    @Override
    public boolean isExist() {
        if (square() == 0) {
            return false;
        }
        double[] sides = new double[6];
        sides[0] = Service.calcDistance(a, b);
        sides[1] = Service.calcDistance(c, d);
        sides[2] = Service.calcDistance(a, c);
        sides[3] = Service.calcDistance(b, d);
        sides[4] = Service.calcDistance(a, d);
        sides[5] = Service.calcDistance(b, c);

        Service.sort(sides);
        return sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3] && sides[4] == sides[5];
    }

    @Override
    public double square() {
        double side = Service.calcDistance(a, b);
        return Math.pow(side, 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Objects.equals(a, square.a) && Objects.equals(b, square.b) && Objects.equals(c, square.c) && Objects.equals(d, square.d);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d);
    }

    @Override
    public String toString() {
        return "Square{" +
                "a=(" + a.getX() + ", " + a.getY() +
                "), b=(" + b.getX() + ", " + b.getY() +
                "), c=(" + c.getX() + ", " + c.getY() +
                "), d=(" + d.getX() + ", " + d.getY() +
                ")}";
    }



}
