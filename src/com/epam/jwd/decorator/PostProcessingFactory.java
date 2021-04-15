package com.epam.jwd.decorator;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.FigurePostProcessor;
import com.epam.jwd.service.impl.FigureExistencePostProcessor;

public class PostProcessingFactory extends FigureFactoryDecorator{
    FigurePostProcessor postProcessor = new FigureExistencePostProcessor();
    PostProcessingFactory(FigureFactory figureFactory) {
        super(figureFactory);
    }

    @Override
    public Figure createFigure(FigureType type, Point[] figureConstituents) throws FigureException {
        Figure figure = super.createFigure(type, figureConstituents);
            postProcessor.postProcess(figure);

        return figure;
    }
}
