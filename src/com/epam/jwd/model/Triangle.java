package com.epam.jwd.model;

import com.epam.jwd.strategy.FigurePropertiesStrategy;

public class Triangle extends Figure {

    Triangle(Point[] points) {
        super(points);
    }

    @Override
    public String toString() {
        return "Triangle{} " + super.toString();
    }
}
