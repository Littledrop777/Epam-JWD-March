package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.service.FigurePostProcessor;
import com.epam.jwd.validation.FigureValidation;
import com.epam.jwd.validation.MultiAngleValidation;
import com.epam.jwd.validation.SquareValidation;
import com.epam.jwd.validation.TriangleValidation;

import java.util.Objects;

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

    @Override
    public void postProcess(Figure figure) throws FigureException {

        if (Objects.isNull(figure)) {
            throw new FigureNotExistException("Figure is null");
        }
        FigureValidation validation;
        switch (figure.getType()) {
            case TRIANGLE:
                validation = TriangleValidation.getInstance();
                if (!validation.validate(figure)) {
                    throw new FigureNotExistException("Figure does not exist " + figure);
                }
                break;
            case SQUARE:
                validation = SquareValidation.getInstance();
                if (!validation.validate(figure)) {
                    throw new FigureNotExistException("Figure isn't a square " + figure);
                }
                break;
            case MULTI_ANGLE:
                validation = MultiAngleValidation.getInstance();
                if (!validation.validate(figure)) {
                    throw new FigureNotExistException("Figure does not exist " + figure);
                }
                break;
        }
    }
}
