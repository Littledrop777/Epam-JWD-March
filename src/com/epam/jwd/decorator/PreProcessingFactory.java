package com.epam.jwd.decorator;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;

public class PreProcessingFactory extends FigureFactoryDecorator{
    PreProcessingFactory(FigureFactory figureFactory) {
        super(figureFactory);
    }

    @Override
    public Figure createFigure(FigureType type, Point[] figureConstituents) throws FigureException {
        return null;
    }
}
