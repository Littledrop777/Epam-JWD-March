package com.epam.jwd.strategy;

import com.epam.jwd.model.Point;

public class MultiAngleFigureService implements FigurePropertiesStrategy {
    private static MultiAngleFigureService instance;

    private MultiAngleFigureService() {

    }

    public static MultiAngleFigureService getInstance() {
        if (instance == null) {
            instance = new MultiAngleFigureService();
        }
        return instance;
    }

    @Override
    public double area(Point... points) {
        return 1;
    }

    @Override
    public double perimeter(Point... points) {
        return 1;
    }

}
