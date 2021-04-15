package com.epam.jwd.model;

import com.epam.jwd.service.FigureData;

public class TriangleData implements FigureData<Triangle> {
    boolean valid;
    double perimeter;
    double area;

    public TriangleData(boolean valid, double perimeter, double area) {
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
