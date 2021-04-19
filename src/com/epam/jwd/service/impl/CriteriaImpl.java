package com.epam.jwd.service.impl;

import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;

public class CriteriaImpl {
    private final FigureType type;
    private final double area;
    private final double perimeter;
    private final int id;
    private final Point point;
    private final double maxNumber;
    private final double minNumber;


    private CriteriaImpl(FigureType type, double area, double perimeter, int id, Point point, double maxNumber, double minNumber) {
        this.type = type;
        this.area = area;
        this.perimeter = perimeter;
        this.id = id;
        this.point = point;
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    public FigureType getType() {
        return type;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public int getId() {
        return id;
    }

    public Point getPoint() {
        return point;
    }

    public double getMaxNumber() {
        return maxNumber;
    }

    public double getMinNumber() {
        return minNumber;
    }

    public static CriteriaBuilder create() {
        return new CriteriaBuilder();
    }


    public static class CriteriaBuilder {
        private FigureType type;
        private double area;
        private double perimeter;
        private int id;
        private Point point;
        private double maxNumber;
        private double minNumber;

        public CriteriaBuilder() {

        }

        public CriteriaBuilder greaterThen(double number) {
            this.minNumber = number;
            return this;
        }

        public CriteriaBuilder fewerThen(double number) {
            this.maxNumber = number;
            return this;
        }

        public CriteriaBuilder hasId(int id) {
            this.id = id;
            return this;
        }

        public CriteriaBuilder whereType(FigureType type) {
            this.type = type;
            return this;
        }

        public CriteriaBuilder area() {
            this.area = 1;
            return this;
        }

        public CriteriaBuilder perimeter() {
            this.perimeter = 1;
            return this;
        }

        public CriteriaBuilder hasPoint(Point point) {
            this.point = point;
            return this;
        }

        public CriteriaImpl build() {
            return new CriteriaImpl(type, area, perimeter, id, point, maxNumber, minNumber);
        }

    }
}
