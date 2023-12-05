package se.eg.aoc.day3;

import java.util.ArrayList;
import java.util.List;

public class EnginePart {

    int number;
    private List<Coordinate> coordinates = new ArrayList<>();

    public EnginePart(Coordinate startCoordinate, Coordinate endCoordinate, int number){
        this.number = number;
        for (int i = startCoordinate.getCol(); i <= endCoordinate.getCol(); i++){
            coordinates.add(new Coordinate(i, startCoordinate.getRow()));
        }
    }

    public int getNumber() {
        return number;
    }

    boolean isAdjacent(Coordinate point){
        return coordinates.stream().anyMatch(c -> c.isAdjacent(point));
    }

    boolean isAdjacentToAny(List<Coordinate> points){
        for (Coordinate coordinate : coordinates){
            for (Coordinate point : points){
                if (coordinate.isAdjacent(point)){
                    return true;
                }
            }
        }
        return false;
    }
}
