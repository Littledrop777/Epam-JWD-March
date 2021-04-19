package com.epam.jwd.decorator;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.FigurePreProcessor;
import com.epam.jwd.service.impl.FigureExistencePreProcessor;

public class PreProcessingFactory extends FigureFactoryDecorator {
    private final FigurePreProcessor preProcess = FigureExistencePreProcessor.getInstance();

    public PreProcessingFactory(FigureFactory figureFactory) {
        super(figureFactory);
    }

    @Override
    public Figure createFigure(FigureType type, Point[] figureConstituents) throws FigureException {
        preProcess.process(type, figureConstituents);
        return super.createFigure(type, figureConstituents);
    }
}
