package com.epam.jwd.app;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws FigureException {
        Factory figure = FigureFactory.INSTANCE;

        Point[] points = new Point[4];
        points[0] = figure.createPoint(3, 7);
        points[1] = figure.createPoint(1, -2);
        points[2] = figure.createPoint(0, 5);
        points[3] = figure.createPoint(-3, 8);

        int i = 0;
        do {
            LOGGER.info(points[i]);
            i++;
        } while (i < points.length);


        Figure[] lines = new Figure[2];
        lines[0] = figure.create(FigureType.LINE, figure.createPoint(0, 12), figure.createPoint(-7, -3));
        lines[1] = figure.create(FigureType.LINE, figure.createPoint(3, 2), figure.createPoint(6, 2));

        for (Figure line : lines) {
            LOGGER.info(line);
        }


        Figure[] triangles = new Figure[2];
        triangles[0] = figure.create(FigureType.TRIANGLE,
                figure.createPoint(0, 0), figure.createPoint(3, 5), figure.createPoint(-1, 9));
        triangles[1] = figure.create(FigureType.TRIANGLE,
                figure.createPoint(-4, -1), figure.createPoint(6, -8), figure.createPoint(0, 5));


        for (Figure triangle : triangles) {
            LOGGER.info(triangle);
        }

        Figure[] squares = new Figure[1];
        squares[0] = figure.create(FigureType.SQUARE,
                figure.createPoint(-4, 4), figure.createPoint(-4, -4),
                figure.createPoint(4, 4), figure.createPoint(4, -4));
        LOGGER.info(squares[0]);
    }

}

