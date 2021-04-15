package com.epam.jwd.validation;

import com.epam.jwd.model.MultiAngle;
import com.epam.jwd.strategy.FigurePropertiesStrategy;
import com.epam.jwd.strategy.MultiAngleFigureService;

public class MultiAngleValidation implements FigureValidation<MultiAngle> {

    private static MultiAngleValidation instance;

    private MultiAngleValidation() {

    }

    public static MultiAngleValidation getInstance() {
        if (instance == null) {
            instance = new MultiAngleValidation();
        }
        return instance;
    }

    FigurePropertiesStrategy<MultiAngle> data = MultiAngleFigureService.getInstance();

    @Override
    public boolean validate(MultiAngle figure) {
        return data.area(figure) != 0;
    }
}
