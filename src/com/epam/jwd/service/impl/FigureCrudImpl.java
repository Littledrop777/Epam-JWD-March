package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.ApplicationContext;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.FigureCrud;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class FigureCrudImpl<T extends Figure> implements FigureCrud<T> {

    public static final Logger LOGGER = LogManager.getLogger(FigureCrudImpl.class);
    private final List<T> storage;

    public FigureCrudImpl(List<T> storage) {
        this.storage = storage;
    }


    @Override
    public Figure create(FigureType type, Point... points) throws FigureException {
        return ApplicationContext.INSTANCE.createFactory().createFigure(type, points);
    }

    @Override
    public Collection<Figure> multiCreate(FigureType type, List<Point[]> points) throws FigureException {
        Collection<Figure> newFigures = new ArrayList<>();
        for (Point[] point : points) {
            newFigures.add(ApplicationContext.INSTANCE.createFactory().createFigure(type, point));
        }
        return newFigures;
    }

    @Override
    public void delete(int id) {
        if (storage.isEmpty()) {
            LOGGER.error("Storage is empty");
        } else {
            storage.removeIf(figure -> figure.getID() == id);
        }
    }

    @Override
    public Optional<T> find(T figure) {
        if (storage.isEmpty()) {
            LOGGER.error("Storage is empty");
            return Optional.empty();
        }
        return storage.stream().filter(figure::equals).findAny();
    }

    @Override
    public void update(T figure) {
        if (storage.isEmpty()) {
            LOGGER.error("Storage is empty");

        } else {
            T changedFigure = storage.stream()
                    .filter(figure1 -> figure1.getID() == figure.getID())
                    .findFirst()
                    .orElse(figure);
            if (!changedFigure.equals(figure)) {
                int index = storage.indexOf(changedFigure);
                storage.set(index, figure);
            } else {
                LOGGER.error("Can't update figure");
            }
        }
    }

    @Override
    public Optional<T> findById(int id) {
        if (storage.isEmpty()) {
            LOGGER.error("Storage is empty");
            return Optional.empty();
        }
        return storage.stream()
                .filter(figure -> figure.getID() == id)
                .findAny();
    }

    @Override
    public Collection<T> findByCriteria(CriteriaImpl criteria) {
        if (storage.isEmpty()) {
            LOGGER.error("Storage is empty");
            return Collections.EMPTY_LIST;
        }
        return storage.stream()
                .filter(figure -> match(figure, criteria))
                .collect(Collectors.toList());
    }

    private boolean match(T figure, CriteriaImpl criteria) {
        List<Boolean> checkList = new ArrayList<>();

        if (criteria.getPoint() != null) {
            checkList.add(Arrays.asList(figure.getPoints()).contains(criteria.getPoint()));
        }
        if (criteria.getArea() != 0 && criteria.getMinNumber() != 0) {
            checkList.add(criteria.getMinNumber() < figure.getArea());
        }
        if (criteria.getArea() != 0 && criteria.getMaxNumber() != 0) {
            checkList.add(criteria.getMaxNumber() > figure.getArea());
        }
        if (criteria.getPerimeter() != 0 && criteria.getMinNumber() != 0) {
            checkList.add(criteria.getMinNumber() < figure.getPerimeter());
        }
        if (criteria.getArea() != 0 && criteria.getMaxNumber() != 0) {
            checkList.add(criteria.getMaxNumber() > figure.getPerimeter());
        }
        if (criteria.getType() != null) {
            checkList.add(criteria.getType().equals(figure.getType()));
        }
        if (checkList.isEmpty()) {
            return false;
        }
        return !checkList.contains(false);
    }
}
