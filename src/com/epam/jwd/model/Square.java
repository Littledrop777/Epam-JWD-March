package com.epam.jwd.model;

import com.epam.jwd.strategy.SquareFigureService;

import java.util.Arrays;

public class Square extends AbstractFigure {

    public Square(Point[] points) {
        super(FigureType.SQUARE, points, SquareFigureService.INSTANCE);
    }

    @Override
    public String toString() {
        return "Square id=" + getID() + " {" + Arrays.toString(getPoints()) + '}';
    }
}
