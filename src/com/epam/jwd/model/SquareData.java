package com.epam.jwd.model;


import com.epam.jwd.model.Square;
import com.epam.jwd.service.FigureData;
import com.epam.jwd.strategy.SquareFigureService;

public class SquareData implements FigureData<Square> {
    private boolean valid;
    private double perimeter;
    private double area;

    public SquareData(boolean valid, double perimeter, double area) {
        this.valid = valid;
        this.perimeter = perimeter;
        this.area = area;
    }

    @Override
    public double area() {
        return area;
    }

    @Override
    public double perimeter() {
        return perimeter;
    }

    @Override
    public boolean isFigure() {
        return valid;
    }
}
