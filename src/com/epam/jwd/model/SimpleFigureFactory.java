package com.epam.jwd.model;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.factory.FigureFactory;

public enum SimpleFigureFactory implements FigureFactory {
    INSTANCE;

    @Override
    public Figure createFigure(FigureType type, Point[] figureConstituents) throws FigureException {

        Figure figure;

        switch (type) {
            case LINE:
                figure = new Line(figureConstituents);
                break;
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

