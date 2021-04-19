package com.epam.jwd.validation;

import com.epam.jwd.model.Square;
import com.epam.jwd.service.Util;
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

    FigurePropertiesStrategy data = SquareFigureService.INSTANCE;

    @Override
    public boolean validate(Square figure) {
        if (data.area(figure.getPoints()) == 0) {
            return false;
        }
        double[] sides = new double[6];
        sides[0] = Util.calcLength(figure.getPoint(0), figure.getPoint(1));
        sides[1] = Util.calcLength(figure.getPoint(2), figure.getPoint(3));
        sides[2] = Util.calcLength(figure.getPoint(0), figure.getPoint(2));
        sides[3] = Util.calcLength(figure.getPoint(1), figure.getPoint(3));
        sides[4] = Util.calcLength(figure.getPoint(0), figure.getPoint(3));
        sides[5] = Util.calcLength(figure.getPoint(1), figure.getPoint(2));

        Util.sort(sides);
        return sides[0] == sides[1] ||
                sides[1] == sides[2] ||
                sides[2] == sides[3] ||
                sides[4] == sides[5];
    }

}
