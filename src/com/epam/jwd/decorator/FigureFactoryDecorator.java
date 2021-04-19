package com.epam.jwd.decorator;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;

public abstract class FigureFactoryDecorator implements FigureFactory {
    private final FigureFactory figureFactory;

    public FigureFactoryDecorator(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    @Override
    public Figure createFigure(FigureType type, Point[] figureConstituents) throws FigureException {
        return figureFactory.createFigure(type, figureConstituents);
    }
}
