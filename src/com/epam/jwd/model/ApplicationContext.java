package com.epam.jwd.model;

import com.epam.jwd.decorator.PostProcessingFactory;
import com.epam.jwd.decorator.PreProcessingFactory;
import com.epam.jwd.factory.FigureFactory;

public enum ApplicationContext {
    INSTANCE;

    public FigureFactory createFactory() {
        return new PostProcessingFactory(new PreProcessingFactory(SimpleFigureFactory.INSTANCE));
    }
}
