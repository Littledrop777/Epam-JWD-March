package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.service.FigurePostProcessor;
import com.epam.jwd.validation.FigureValidation;
import com.epam.jwd.validation.MultiAngleValidation;
import com.epam.jwd.validation.SquareValidation;
import com.epam.jwd.validation.TriangleValidation;

public class FigureExistencePostProcessor implements FigurePostProcessor {

    private static FigureExistencePostProcessor instance;

    public FigureExistencePostProcessor() {

    }

    public static FigureExistencePostProcessor getInstance() {
        if (instance == null) {
            instance = new FigureExistencePostProcessor();
        }
        return instance;
    }

    FigureValidation validation;

    @Override
    public Figure postProcess(Figure figure) throws FigureException {
        int pointsAmount = figure.getPoints().length;

        switch (pointsAmount) {
            case 3:
                validation = TriangleValidation.getInstance();
                break;
            case 4:
                validation = SquareValidation.getInstance();
                break;
            default:
                if (pointsAmount > 4) {
                    validation = MultiAngleValidation.getInstance();
                    break;
                } else {
                    throw new FigureNotExistException("Unknown figure " + figure);
                }
        }

        if (!validation.validate(figure)) {
            throw new FigureNotExistException("Figure doesn't exist " + figure);
        }

        return figure;
    }
}
