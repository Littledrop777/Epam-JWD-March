package com.epam.jwd.model;

import com.epam.jwd.strategy.FigurePropertiesStrategy;

import java.util.Arrays;
import java.util.Objects;

public abstract class AbstractFigure implements Figure {
    private final FigurePropertiesStrategy figureProperties;
    private final Point[] points;
    private final FigureType type;
    private int id;
    private static int count;

    protected AbstractFigure(FigureType type, Point[] points, FigurePropertiesStrategy figureProperties) {
        this.figureProperties = figureProperties;
        this.points = points;
        this.type = type;
    }

    @Override
    public FigureType getType() {
        return type;
    }

    @Override
    public Point[] getPoints() {
        return points;
    }

    @Override
    public Point getPoint(int index) {
        return points[index];
    }

    @Override
    public void setId() {
        id = ++count;

    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public double getArea() {
        return figureProperties.area(points);
    }

    @Override
    public double getPerimeter() {
        return figureProperties.perimeter(points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractFigure that = (AbstractFigure) o;
        return id == that.id && Objects.equals(figureProperties, that.figureProperties) && Arrays.equals(points, that.points) && type == that.type;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(figureProperties, type, id);
        result = 31 * result + Arrays.hashCode(points);
        return result;
    }

    @Override
    public String toString() {
        return "id = " + id + "{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
}
