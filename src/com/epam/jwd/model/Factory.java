package com.epam.jwd.model;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;

public interface Factory {
    Figure create(FigureType type, Point... points) throws FigureException;

    Point createPoint(double x, double y);

}
