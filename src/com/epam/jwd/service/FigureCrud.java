package com.epam.jwd.service;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.impl.CriteriaImpl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface FigureCrud<T extends Figure> {
    Figure create(FigureType type, Point... points) throws FigureException;

    Collection<Figure> multiCreate(FigureType type, List<Point[]> points) throws FigureException;

    void delete(int id);

    Optional<T> find(T figure);

    void update(T figure);

    Optional<T> findById(int id);

    Collection<T> findByCriteria(CriteriaImpl criteria);
}
