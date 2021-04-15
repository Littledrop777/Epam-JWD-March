package com.epam.jwd.strategy;

import com.epam.jwd.model.Figure;

public interface FigurePropertiesStrategy<T extends Figure>{
    double area(T figure);

    double perimeter(T figure);

}
