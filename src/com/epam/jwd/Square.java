package com.epam.jwd;

import java.util.Objects;

public class Square implements Figure{
    private Point a;
    private Point b;
    private Point c;
    private Point d;

    public Square(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public boolean isSquare(){
        return false;
    }

    @Override
    public boolean isShape() {
        return !a.equals(b) && !b.equals(c) && !c.equals(d) && !a.equals(d);
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
                "), b=(" + b.getX() + ", " + b.getY()+
                "), c=(" + c.getX() + ", " + c.getY()+
                "), d=(" + d.getX() + ", " + d.getY()+
                ")}";
    }


    @Override
    public double square() {
        return 0;
    }

    @Override
    public boolean isExist() {
        return false;
    }
}
