package se.eg.aoc.day3;

import lombok.Getter;

import java.util.List;

public class Symbol {

    private Coordinate coordinate;
    private String symbol;

    public Symbol(Coordinate coordinate, String symbol) {
        this.coordinate = coordinate;
        this.symbol = symbol;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public String getSymbol() {
        return symbol;
    }

    boolean isGear(List<EnginePart> engineParts){
        var wrappedCoordinate  = List.of(coordinate);
        return engineParts.stream().filter(e -> e.isAdjacentToAny(wrappedCoordinate)).count() > 1;
    }

}
