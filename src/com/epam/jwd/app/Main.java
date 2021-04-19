package com.epam.jwd.app;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.*;
import com.epam.jwd.service.impl.CriteriaImpl;
import com.epam.jwd.service.impl.FigureCrudImpl;
import com.epam.jwd.storage.Storage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        FigureFactory factory = ApplicationContext.INSTANCE.createFactory();
        FactoryPoint point = PointFactory.INSTANCE;
        FigureCrudImpl figureCrud = new FigureCrudImpl(Storage.INSTANCE.getStorage());

        List<Point> points = new ArrayList<>();
        points.add(point.createPoint(3, 7));
        points.add(point.createPoint(1, -2));
        points.add(point.createPoint(0, 5));
        points.add(point.createPoint(-3, 8));

        int i = 0;
        do {
            LOGGER.info(points);
            i++;
        } while (i < points.size());

        try {
            List<Figure> lines = new ArrayList<>();
            lines.add(factory.createFigure(FigureType.LINE, point.createPoint(0, 12), point.createPoint(-7, -3)));
            lines.add(factory.createFigure(FigureType.LINE, point.createPoint(3, 2), point.createPoint(6, 2)));

            List<Figure> triangles = new ArrayList<>();
            triangles.add(factory.createFigure(FigureType.TRIANGLE,
                    point.createPoint(0, 0), point.createPoint(3, 5), point.createPoint(-1, 9)));
            triangles.add(factory.createFigure(FigureType.TRIANGLE,
                    point.createPoint(-4, -1), point.createPoint(6, -8), point.createPoint(0, 5)));

            List<Figure> squares = new ArrayList<>();
            squares.add(factory.createFigure(FigureType.SQUARE,
                    point.createPoint(-4, 4), point.createPoint(-4, -4),
                    point.createPoint(4, 4), point.createPoint(4, -4)));
        } catch (FigureException e) {
            LOGGER.error(e);
        }
        CriteriaImpl cr = CriteriaImpl.create()
                .perimeter()
                .greaterThen(15)
                .area()
                .fewerThen(115)
                .build();

        Collection<Figure> figure = figureCrud.findByCriteria(cr);
        LOGGER.info("Figures have been found by criteria");
        figure.forEach(LOGGER::info);

        Point[] points1 = {point.createPoint(1, 3), point.createPoint(7, 2), point.createPoint(-3, -5)};
        Point[] points2 = {point.createPoint(0, -7), point.createPoint(-2, 9), point.createPoint(5, 0)};
        Point[] points3 = {point.createPoint(-5, 4), point.createPoint(-6, 0), point.createPoint(0, 9)};


        List<Point[]> pointsForCreate = new ArrayList<>();
        pointsForCreate.add(points1);
        pointsForCreate.add(points2);
        pointsForCreate.add(points3);

        try {
            Collection<Figure> newFigures = figureCrud.multiCreate(FigureType.TRIANGLE, pointsForCreate);
        } catch (FigureException e) {
            LOGGER.error(e);
        }
    }

}

