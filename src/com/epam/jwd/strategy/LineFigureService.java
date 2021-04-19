package com.epam.jwd.strategy;

import com.epam.jwd.model.Point;

public enum LineFigureService implements FigurePropertiesStrategy {
    INSTANCE;

    @Override
    public double area(Point... points) {
        return 0;
    }

    @Override
    public double perimeter(Point... points) {
        double oneSide;
        double secondSide;

        oneSide = Math.pow((points[0].getX() - points[1].getX()), 2);
        secondSide = Math.pow((points[0].getY() - points[1].getY()), 2);
        return Math.sqrt(oneSide + secondSide);

    }
}
