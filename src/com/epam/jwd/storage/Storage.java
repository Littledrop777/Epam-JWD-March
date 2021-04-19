package com.epam.jwd.storage;

import com.epam.jwd.model.Figure;

import java.util.ArrayList;
import java.util.List;

public enum Storage {
    INSTANCE;
    private final List<Figure> figureStorage = new ArrayList<>();

    public void addFigure(Figure figure) {
        figureStorage.add(figure);
    }

    public List<Figure> getStorage() {
        return figureStorage;
    }
}
