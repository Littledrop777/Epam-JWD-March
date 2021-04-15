package com.epam.jwd.service;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;

public interface FigurePostProcessor<T extends Figure> {

    Figure postProcess(T figure)throws FigureException;
}

