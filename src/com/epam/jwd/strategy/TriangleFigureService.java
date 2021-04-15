package com.epam.jwd.strategy;

import com.epam.jwd.model.Point;
import com.epam.jwd.model.Triangle;
import com.epam.jwd.service.Service;

public class TriangleFigureService implements FigurePropertiesStrategy<Triangle> {

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
    public double area(Triangle figure) {
        double result;
        Point a = figure.getPoint(0);
        Point b = figure.getPoint(1);
        Point c = figure.getPoint(2);
        // s = Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)) / 2;
        result = Math.abs((b.getX() - a.getX()) * (c.getY() - a.getY()) - (c.getX() - a.getX()) * (b.getY() - a.getY())) / 2;
        return result;
    }

    @Override
    public double perimeter(Triangle figure) {

        Point a = figure.getPoint(0);
        Point b = figure.getPoint(1);
        Point c = figure.getPoint(2);

        double ab = Service.calcLength(a, b);
        double bc = Service.calcLength(b, c);
        double ac = Service.calcLength(a, c);

        return ab + bc + ac;
    }


}
