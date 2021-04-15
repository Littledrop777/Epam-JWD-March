package com.epam.jwd.model;


import com.epam.jwd.strategy.FigurePropertiesStrategy;

public class Line extends Figure {

    public Line(Point[] points) {
        super(points);
    }


    @Override
    public String toString() {
        return "Line{} " + super.toString();
    }
}

