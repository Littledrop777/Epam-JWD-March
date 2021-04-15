package com.epam.jwd.model;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.factory.FigureFactory;

public class SimpleFigureFactory implements FigureFactory {

    @Override
    public Figure createFigure(FigureType type, Point[] figureConstituents) throws FigureException {

        Figure figure;

        switch (type) {
            case LINE:
                return new Line(figureConstituents);
            case TRIANGLE:
                figure = new Triangle(figureConstituents);
                break;
            case SQUARE:
                figure = new Square(figureConstituents);
                break;
            case MULTI_ANGLE:
                figure = new MultiAngle(figureConstituents);
                break;
            default:
                throw new FigureNotExistException("Unexpected value: " + type);
        }

        return figure;
    }
}

