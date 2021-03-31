package com.epam.jwd;

import java.util.Objects;

public class Triangle implements Shape {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
public double calcSquare(){
   // s = Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)) / 2;
return 0;

}
    public boolean isTriangle(){

        int x1;
        int y1;

        int x2;
        int y2;

        int x3;
        int y3;

        int s;

        x1 = 2;
        y1 = 5;

        x2 = 4;
        y2 = 7;

        x3 = 6;
        y3 = 9;

        s = Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)) / 2;

        return s!=0;

    }

    @Override
    public boolean isShape() {
        return !a.equals(b) && !b.equals(c) && !a.equals(c);
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
