package com.epam.jwd.strategy;

import com.epam.jwd.model.Line;

public enum LineFigureService implements FigurePropertiesStrategy<Line>{

    INSTANCE;

    @Override
    public double area(Line figure) {
        return 0;
    }

    @Override
    public double perimeter(Line figure) {
        return 0;
    }

}
