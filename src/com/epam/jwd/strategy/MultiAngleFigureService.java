package com.epam.jwd.strategy;

import com.epam.jwd.model.MultiAngle;

public class MultiAngleFigureService implements FigurePropertiesStrategy<MultiAngle> {
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
    public double area(MultiAngle figure) {
        return 1;
    }

    @Override
    public double perimeter(MultiAngle figure) {
        return 2;
    }

}
