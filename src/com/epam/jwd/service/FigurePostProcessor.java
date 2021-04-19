package com.epam.jwd.service;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;

public interface FigurePostProcessor<T extends Figure> {

    void postProcess(T figure) throws FigureException;
}

