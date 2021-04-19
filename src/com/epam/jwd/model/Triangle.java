package com.epam.jwd.model;

import com.epam.jwd.strategy.TriangleFigureService;

import java.util.Arrays;

public class Triangle extends AbstractFigure {

    Triangle(Point[] points) {
        super(FigureType.TRIANGLE, points, TriangleFigureService.getInstance());
    }

    @Override
    public String toString() {
        return "Triangle id=" + getID() + " {" + Arrays.toString(getPoints()) + '}';
    }

}
