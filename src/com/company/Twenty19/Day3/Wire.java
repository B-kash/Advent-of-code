package com.company.Twenty19.Day3;

import java.util.ArrayList;

public class Wire {
    private ArrayList<Line> lines = new ArrayList<>();

    public Wire(String[] wireInput) {
        for (int i = 0; i < wireInput.length; i++) {
            String currentLine = wireInput[i];
            String directionString = currentLine.substring(0, 1);
            int steps = Integer.parseInt(currentLine.substring(1));
            Direction direction;
            switch (directionString) {
                case "L":
                    direction = Direction.LEFT;
                    break;
                case "R":
                    direction = Direction.RIGHT;
                    break;
                case "U":
                    direction = Direction.UP;
                    break;
                default:
                    direction = Direction.DOWN;
                    break;
            }
            if (lines.size() == 0) {
                lines.add(new Line(new Point(0, 0), steps, direction));
            } else {
                lines.add(new Line(lines.get(i - 1).getEndPoint(), steps, direction));
            }
        }
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    public ArrayList<Point> intersect(Wire anotherWire) {
        ArrayList<Point> result = new ArrayList<>();
        for (Line line : getLines()) {
            for (Line anotherLine : anotherWire.getLines()) {
                ArrayList<Point> intersects = line.intersect(anotherLine);
                if (intersects != null && intersects.size() > 0) {
                    result.addAll(intersects);
                }
            }
        }
        return result;
    }

    public int traverse(Point point){
        int cost = 0;
        for(Line line: this.lines){
            if (line.contains(point)){
                cost += line.getStartingPoint().distance(point);
                break;
            } else {
                cost += line.getSteps();
            }
        }
        return cost;
    }
}
