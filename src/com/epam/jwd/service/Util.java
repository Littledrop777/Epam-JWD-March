package com.epam.jwd.service;

import com.epam.jwd.model.Point;

public class Util {
    public static void sort(double[] array) {

        double temp;
        boolean check;
        int count = array.length - 1;

        do {
            check = false;

            for (int i = 0; i < count; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;

                    check = true;
                }

            }
            count--;
        } while (check);
    }

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
