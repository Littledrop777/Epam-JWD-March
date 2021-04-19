package com.epam.jwd.strategy;

import com.epam.jwd.model.Point;
import com.epam.jwd.service.Util;

public enum SquareFigureService implements FigurePropertiesStrategy {

    INSTANCE;

    @Override
    public double area(Point... points) {

        return Math.pow(Util.calcLength(points[0], points[1]), 2);
    }

    @Override
    public double perimeter(Point... points) {

        return Util.calcLength(points[0], points[1]) * 4;
    }


}
