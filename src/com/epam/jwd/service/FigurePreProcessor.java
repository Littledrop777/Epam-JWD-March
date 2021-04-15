package com.epam.jwd.service;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;

public interface FigurePreProcessor {
    void preProcess(FigureType type, Point... points)throws FigureException;
}
