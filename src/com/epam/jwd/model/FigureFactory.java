package com.epam.jwd.model;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.service.FigurePostProcessor;
import com.epam.jwd.service.FigurePreProcessor;
import com.epam.jwd.service.impl.FigureExistencePostProcessor;
import com.epam.jwd.service.impl.FigureExistencePreProcessor;

public enum FigureFactory implements Factory {
    INSTANCE;
    private final FigurePreProcessor preProcessor = FigureExistencePreProcessor.getInstance();
    private final FigurePostProcessor postProcessor = FigureExistencePostProcessor.getInstance();

    @Override
    public Figure create(FigureType type, Point... points) throws FigureException {

        preProcessor.preProcess(type, points);

        Figure figure;

        switch (type) {
            case LINE:
                return new Line(points);
            case TRIANGLE:
                figure = new Triangle(points);
                break;
            case SQUARE:
                figure = new Square(points);
                break;
            case MULTI_ANGLE:
                figure = new MultiAngle(points);
                break;
            default:
                throw new FigureNotExistException("Unexpected value: " + type);
        }
        postProcessor.postProcess(figure);
        return figure;
    }


    @Override
    public Point createPoint(double x, double y) {
        return new Point(x, y);
    }

}
