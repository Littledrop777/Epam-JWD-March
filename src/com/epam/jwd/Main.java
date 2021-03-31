package com.epam.jwd;

import com.epam.jwd.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        FactoryShape shape = new FactoryShape();

        Point[] points = new Point[4];

        points[0] = shape.createPoint(3, 7);
        points[1] = shape.createPoint(1, -2);
        points[2] = shape.createPoint(0, 5);
        points[3] = shape.createPoint(-3, 8);

        int i = 0;
        do {
            LOGGER.info(points[i]);
            i++;
        } while (i < points.length);

        Shape[] lines = new Line[2];
        lines[0] = shape.createLine(shape.createPoint(0, 12), shape.createPoint(-7, -3));
        lines[1] = shape.createLine(shape.createPoint(6, 2), shape.createPoint(6, 2));

        for (Shape line : lines) {
            if (line.isShape()) {
                LOGGER.error("Is not a figure");
            } else {
                LOGGER.info(line);
            }
        }

        Figure[] triangles = new Triangle[2];
        triangles[0] = shape.createTriangle(
                shape.createPoint(-2, 7), shape.createPoint(3, 5), shape.createPoint(2, 9));
        triangles[1] = shape.createTriangle(
                shape.createPoint(-4, -1), shape.createPoint(6, -8), shape.createPoint(0, 5));

        for (Figure triangle : triangles) {
            if (triangle.isShape()) {
                LOGGER.error("Is not a figure");
            } else if (!triangle.isExist()) {
                LOGGER.error(String.format("Triangle %s cannot exist", triangle));
            } else {
                LOGGER.info(triangle);
            }
        }

        Figure[] squares = new Square[1];
        squares[0] = shape.createSquare(
                shape.createPoint(0, 9), shape.createPoint(-2, 4),
                shape.createPoint(5, -11), shape.createPoint(-3, -3));

        if (squares[0].isShape()) {
            LOGGER.error("Is not a figure");
        } else if (!squares[0].isExist()) {
            LOGGER.error(String.format("Square %s is not a figure", squares[0]));
        } else {
            LOGGER.info(squares[0]);
        }

    }
}
