package com.epam.jwd.strategy;

import com.epam.jwd.model.Point;
import com.epam.jwd.service.Util;

public class TriangleFigureService implements FigurePropertiesStrategy{

    private static TriangleFigureService triangle_instance;

    private TriangleFigureService() {

    }

    public static TriangleFigureService getInstance() {
        if (triangle_instance == null) {
            triangle_instance = new TriangleFigureService();
        }
        return triangle_instance;
    }


    @Override
    public double area(Point... points) {
        double result;
        Point a = points[0];
        Point b = points[1];
        Point c = points[2];
        // s = Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)) / 2;
        result = Math.abs((b.getX() - a.getX()) * (c.getY() - a.getY()) - (c.getX() - a.getX()) * (b.getY() - a.getY())) / 2;
        return result;
    }

    @Override
    public double perimeter(Point... points) {

        Point a = points[0];
        Point b = points[1];
        Point c = points[2];

        double ab = Util.calcLength(a, b);
        double bc = Util.calcLength(b, c);
        double ac = Util.calcLength(a, c);

        return ab + bc + ac;
    }


}
