package com.epam.jwd.model;

import com.epam.jwd.strategy.FigurePropertiesStrategy;

public class Square extends Figure {

    public Square(Point[] points) {
        super(points);
    }

    @Override
    public String toString() {
        return "Square{} " + super.toString();
    }
}
