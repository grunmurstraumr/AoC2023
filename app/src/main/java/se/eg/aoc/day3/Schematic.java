package se.eg.aoc.day3;

import org.checkerframework.checker.units.qual.A;
import se.eg.aoc.util.FileReader;

import java.util.ArrayList;
import java.util.List;

public class Schematic {
    private List<List<String>> rawSchematic;

    private List<EnginePart> engineParts;
    private List<Coordinate> symbols;

    public Schematic() {
        rawSchematic = new ArrayList<>();
        engineParts = new ArrayList<>();
        symbols = new ArrayList<>();
    }

    public void readFromFile(String filename) {
        var lines = FileReader.readInputFile(filename);
        for (var line : lines) {
            rawSchematic.add(List.of(line.split("")));
        }
        parseRawScehmatic();
    }

    private void parseRawScehmatic() {
        for (int row = 0; row < rawSchematic.size(); row++) {
            Coordinate startCoordinate = null;
            StringBuilder stringBuilder = new StringBuilder();
            for (int col = 0; col < rawSchematic.get(row).size(); col++) {
                String currentItem = rawSchematic.get(row).get(col);
                if (currentItem.matches("\\.")) {
                    if (startCoordinate != null) {
                        int number = Integer.parseInt(stringBuilder.toString());
                        engineParts.add(new EnginePart(startCoordinate, new Coordinate(col - 1, row), number));
                        stringBuilder = new StringBuilder();
                        startCoordinate = null;
                    }
                } else if (currentItem.matches("\\d")) {
                    stringBuilder.append(currentItem);
                    if (startCoordinate == null) {
                        startCoordinate = new Coordinate(col, row);
                    }
                } else {
                    if (startCoordinate != null) {
                        int number = Integer.parseInt(stringBuilder.toString());
                        engineParts.add(new EnginePart(startCoordinate, new Coordinate(col - 1, row), number));
                        stringBuilder = new StringBuilder();
                        startCoordinate = null;
                    }
                    symbols.add(new Coordinate(col, row));

                }
            }
            if (startCoordinate != null) {
                int number = Integer.parseInt(stringBuilder.toString());
                engineParts.add(new EnginePart(startCoordinate, new Coordinate(rawSchematic.get(row).size() - 1, row), number));
            }

        }
    }

    public List<EnginePart> getAdjacentEngineParts() {
        List<EnginePart> adjacentParts = engineParts.stream().filter(e -> e.isAdjacentToAny(symbols)).toList();
        return adjacentParts;
    }
}
