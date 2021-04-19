package com.epam.jwd.decorator;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.FigurePostProcessor;
import com.epam.jwd.service.impl.FigureAdditionalPostProcessor;
import com.epam.jwd.service.impl.FigureExistencePostProcessor;

import java.util.ArrayList;
import java.util.List;

public class PostProcessingFactory extends FigureFactoryDecorator {
    private final List<FigurePostProcessor> postProcessList = new ArrayList<>();

    {
        postProcessList.add(FigureExistencePostProcessor.getInstance());
        postProcessList.add(FigureAdditionalPostProcessor.getInstance());
    }

    public PostProcessingFactory(FigureFactory figureFactory) {
        super(figureFactory);
    }

    public void addPostProcess(FigurePostProcessor postProcessor) {
        postProcessList.add(postProcessor);
    }

    public void removePostProcess(FigurePostProcessor postProcessor) {
        postProcessList.remove(postProcessor);
    }

    @Override
    public Figure createFigure(FigureType type, Point[] figureConstituents) throws FigureException {
        Figure figure = super.createFigure(type, figureConstituents);
        for (FigurePostProcessor figurePostProcessor : postProcessList) {
            figurePostProcessor.postProcess(figure);
        }
        return figure;
    }
}
