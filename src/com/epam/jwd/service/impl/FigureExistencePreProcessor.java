package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.FigurePreProcessor;
import com.epam.jwd.service.Util;

public class FigureExistencePreProcessor implements FigurePreProcessor {
    private static FigureExistencePreProcessor instance;

    private FigureExistencePreProcessor() {

    }

    public static FigureExistencePreProcessor getInstance() {
        if (instance == null) {
            instance = new FigureExistencePreProcessor();
        }
        return instance;
    }

    @Override
    public void process(FigureType type, Point... points) throws FigureNotExistException {
        if (!Util.valid(points)) {
            throw new FigureNotExistException("Object is not a figure " + type);
        }
        int size = points.length;
        switch (type) {
            case LINE:
                if (size != 2) {
                    throw new FigureNotExistException("Incorrect amount of points " + type);
                }
                break;
            case TRIANGLE:
                if (size != 3) {
                    throw new FigureNotExistException("Incorrect amount of points " + type);
                }
                break;
            case SQUARE:
                if (size != 4) {
                    throw new FigureNotExistException("Incorrect amount of points " + type);
                }
                break;
            case MULTI_ANGLE:
                if (size < 3) {
                    throw new FigureNotExistException("Incorrect amount of points " + type);
                }
                break;
            default:
                throw new FigureNotExistException("Unexpected value " + type);
        }
    }

}
