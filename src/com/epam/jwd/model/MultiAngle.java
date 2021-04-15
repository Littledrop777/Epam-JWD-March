package com.epam.jwd.model;

import com.epam.jwd.strategy.FigurePropertiesStrategy;

public class MultiAngle extends Figure {

    MultiAngle(Point[] points) {
        super(points);
    }


    @Override
    public String toString() {
        return "MultiAngleFigure{} " + super.toString();
    }
}
