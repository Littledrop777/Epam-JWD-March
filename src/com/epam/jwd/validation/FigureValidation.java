package com.epam.jwd.validation;

import com.epam.jwd.model.Figure;

public interface FigureValidation<T extends Figure> {
    boolean validate(T figure);
}
