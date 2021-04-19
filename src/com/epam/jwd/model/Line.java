package com.epam.jwd.model;

import com.epam.jwd.strategy.LineFigureService;

import java.util.Arrays;

public class Line extends AbstractFigure {

    public Line(Point[] points) {
        super(FigureType.LINE, points, LineFigureService.INSTANCE);
    }

    @Override
    public String toString() {
        return "Line id=" + getID() + " {" + Arrays.toString(getPoints()) + '}';
    }
}

