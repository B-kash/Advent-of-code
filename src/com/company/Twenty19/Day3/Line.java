package com.company.Twenty19.Day3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Line {
    private Point startingPoint;
    private int steps;
    private Direction direction;
    private Map<String, Point> path = new HashMap<String, Point>(); // will be calculated later
    private Point endPoint;

    public Line(Point startingPoint, int steps, Direction direction) {
        this.startingPoint = startingPoint;
        this.steps = steps;
        this.direction = direction;
        createPath();
    }

    public Point getStartingPoint() {
        return startingPoint;
    }

    private void createPath() {
        Point lastKnownEndPoint = null;
        for (int i = 0; i <= steps; i++) {
            lastKnownEndPoint = new Point(startingPoint.getX() + i * getCalculatedMultiplier("x"), startingPoint.getY() + i * getCalculatedMultiplier("y"));
            this.path.put(String.valueOf(i), lastKnownEndPoint);
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

    public int getSteps() {
        return steps;
    }

    public Point getEndPoint() {
        return endPoint;
    }


    public Map<String, Point> getPath() {
        return path;
    }

    public ArrayList<Point> intersect(Line anotherLine) {
        ArrayList<Point> result = new ArrayList<>();
        anotherLine.path.forEach((key,value)->{
            if(this.path.containsValue(value)){
                result.add(value);
            }
        });
        return result;
    }

    public boolean contains(Point point) {
        return this.path.containsValue(point);
    }
}

