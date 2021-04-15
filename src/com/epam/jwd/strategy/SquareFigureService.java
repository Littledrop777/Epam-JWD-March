package com.epam.jwd.strategy;

import com.epam.jwd.model.Point;
import com.epam.jwd.model.Square;
import com.epam.jwd.service.Service;

public enum SquareFigureService implements FigurePropertiesStrategy<Square> {

    INSTANCE;

    @Override
    public double area(Square figure) {
        double result;
        Point a = figure.getPoint(0);
        Point b = figure.getPoint(1);
        result = Math.pow(Service.calcLength(a, b), 2);

        return result;
    }

    @Override
    public double perimeter(Square figure) {
        Point a = figure.getPoint(0);
        Point b = figure.getPoint(1);

        return Service.calcLength(a, b) * 4;
    }


}
