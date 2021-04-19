package com.epam.jwd.model;

import com.epam.jwd.strategy.MultiAngleFigureService;

import java.util.Arrays;

public class MultiAngle extends AbstractFigure {

    MultiAngle(Point[] points) {
        super(FigureType.MULTI_ANGLE, points, MultiAngleFigureService.getInstance());
    }

    @Override
    public String toString() {
        return "MultiAngle id=" + getID() + " {" + Arrays.toString(getPoints()) + '}';
    }
}
