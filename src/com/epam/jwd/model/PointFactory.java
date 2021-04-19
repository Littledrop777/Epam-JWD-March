package com.epam.jwd.model;

public enum PointFactory implements FactoryPoint {
    INSTANCE;

    @Override
    public Point createPoint(double x, double y) {
        return new Point(x, y);
    }

}
