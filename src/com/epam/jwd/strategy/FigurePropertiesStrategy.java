package com.epam.jwd.strategy;

import com.epam.jwd.model.Point;

public interface FigurePropertiesStrategy {
    double area(Point... points);

    double perimeter(Point... points);

}
