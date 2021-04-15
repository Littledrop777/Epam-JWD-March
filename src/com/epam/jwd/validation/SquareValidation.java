package com.epam.jwd.validation;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Square;
import com.epam.jwd.service.Service;
import com.epam.jwd.strategy.FigurePropertiesStrategy;
import com.epam.jwd.strategy.SquareFigureService;

public class SquareValidation implements FigureValidation<Square> {
    private static SquareValidation instance;

    private SquareValidation() {

    }

    public static SquareValidation getInstance() {
        if (instance == null) {
            instance = new SquareValidation();
        }
        return instance;
    }
    FigurePropertiesStrategy<Square> data = SquareFigureService.INSTANCE;

    @Override
    public boolean validate(Square figure) {
        if (data.area(figure) == 0) {
            return false;
        }
        double[] sides = new double[6];
        sides[0] = Service.calcLength(figure.getPoint(0), figure.getPoint(1));
        sides[1] = Service.calcLength(figure.getPoint(2), figure.getPoint(3));
        sides[2] = Service.calcLength(figure.getPoint(0), figure.getPoint(2));
        sides[3] = Service.calcLength(figure.getPoint(1), figure.getPoint(3));
        sides[4] = Service.calcLength(figure.getPoint(0), figure.getPoint(3));
        sides[5] = Service.calcLength(figure.getPoint(1), figure.getPoint(2));

        Service.sort(sides);
        return sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3] && sides[4] == sides[5];
    }

}
