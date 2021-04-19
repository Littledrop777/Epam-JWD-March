package com.epam.jwd.service.impl;

import com.epam.jwd.model.Figure;
import com.epam.jwd.service.FigurePostProcessor;
import com.epam.jwd.storage.Storage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FigureAdditionalPostProcessor implements FigurePostProcessor {
    private static FigureAdditionalPostProcessor instance;
    private final Storage figureStorage = Storage.INSTANCE;
    public static final Logger LOGGER = LogManager.getLogger(FigureExistencePostProcessor.class);

    public FigureAdditionalPostProcessor() {

    }

    public static FigureAdditionalPostProcessor getInstance() {
        if (instance == null) {
            instance = new FigureAdditionalPostProcessor();
        }
        return instance;
    }


    @Override
    public void postProcess(Figure figure) {
        figure.setId();
        figureStorage.addFigure(figure);
        LOGGER.info(figure);
    }
}
