package com.epam.jwd.model;

public interface Figure {

    FigureType getType();

    Point[] getPoints();

    Point getPoint(int index);

    void setId();

    int getID();

    double getArea();

    double getPerimeter();
}
