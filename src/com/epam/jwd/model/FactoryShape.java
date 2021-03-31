package com.epam.jwd.model;

import com.epam.jwd.model.Line;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.Square;
import com.epam.jwd.model.Triangle;

public class FactoryShape {

    public Point createPoint(double x, double y) {
        return new Point(x, y);
    }

    public Line createLine(Point x, Point y) {
        return new Line(x, y);
    }

    public Triangle createTriangle(Point a, Point b, Point c) {
        return new Triangle(a,b,c);
    }

    public Square createSquare(Point a, Point b, Point c, Point d) {
        return new Square(a,b,c,d);
    }

/*    public Shape create(ShapeType type, Point... points) throws IllegalStateException {

        Shape shape;

        switch (type) {
            case LINE:
                shape = new Line(points[0], points[1]);
                break;
            case TRIANGLE:
                shape = new Triangle(points[0], points[1], points[2]);
                break;
            case SQUARE:
                shape = new Square(points[0], points[1], points[2], points[3]);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return shape;
    }*/
}
