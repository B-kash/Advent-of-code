package com.company.Twenty19.Day3;

import java.util.ArrayList;

public class Line {
    private Point startingPoint;
    private int steps;
    private Direction direction;
    private ArrayList<Point> path = new ArrayList<>(); // will be calculated later
    private Point endPoint;

    public Line(Point startingPoint, int steps, Direction direction) {
        this.startingPoint = startingPoint;
        this.steps = steps;
        this.direction = direction;
        createPath();
    }

    private void createPath() {
        Point lastKnownEndPoint = null;
        for (int i = 0; i <= steps; i++) {
            lastKnownEndPoint = new Point(startingPoint.getX() + i * getCalculatedMultiplier("x"), startingPoint.getY() + i * getCalculatedMultiplier("y"));
            path.add(lastKnownEndPoint);
        }
        endPoint = lastKnownEndPoint;
    }

    private int getCalculatedMultiplier(String axis) {
        int multiplier = 0;
        switch (direction) {
            case LEFT:
                if (axis.equals("x")) {
                    multiplier = -1;
                }
                break;
            case RIGHT:
                if (axis.equals("x")) {
                    multiplier = 1;
                }
                break;
            case UP:
                if (axis.equals("y")) {
                    multiplier = 1;
                }
                break;
            default:
                if (axis.equals("y")) {
                    multiplier = -1;
                }
                break;
        }
        return multiplier;

    }

    public Point getEndPoint() {
        return endPoint;
    }


    public ArrayList<Point> getPath() {
        return path;
    }

    public ArrayList<Point> intersect(Line anotherLine) {
        ArrayList<Point> result = new ArrayList<>();
        for (Point point : this.getPath()) {
            for (Point anotherPoint : anotherLine.getPath()) {
                if (point.distance(anotherPoint) == 0) {
                    result.add(point);
                }

            }
        }
        return result;
    }

}

