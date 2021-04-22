package com.epam.jwd.service;

import com.epam.jwd.model.Point;

public class Util {

    public static double calcLength(Point a, Point b) {
        double result;
        double oneSide;
        double secondSide;

        oneSide = Math.pow((b.getX() - a.getX()), 2);
        secondSide = Math.pow((b.getY() - a.getY()), 2);
        result = Math.sqrt(oneSide + secondSide);

        return result;
    }

    public static boolean valid(Point... points) {
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].equals(points[j])) {
                    return false;
                }
            }
        }
        return true;
    }
}
