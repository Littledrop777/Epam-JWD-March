package com.epam.jwd.validation;

import com.epam.jwd.model.Triangle;
import com.epam.jwd.strategy.FigurePropertiesStrategy;
import com.epam.jwd.strategy.TriangleFigureService;

public class TriangleValidation implements FigureValidation<Triangle> {
    private static TriangleValidation instance;

    private TriangleValidation() {

    }

    public static TriangleValidation getInstance() {
        if (instance == null) {
            instance = new TriangleValidation();
        }
        return instance;
    }

    FigurePropertiesStrategy data = TriangleFigureService.getInstance();

    @Override
    public boolean validate(Triangle figure) {
        return !(data.area(figure.getPoints()) == 0);
    }

}
