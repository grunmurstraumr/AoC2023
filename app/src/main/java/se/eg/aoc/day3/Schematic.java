package se.eg.aoc.day3;

import se.eg.aoc.util.FileReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Schematic {
    private List<List<String>> rawSchematic;

    private List<EnginePart> engineParts;
    private List<Coordinate> symbolCoordinate;
    private List<Symbol> symbols;

    public Schematic() {
        rawSchematic = new ArrayList<>();
        engineParts = new ArrayList<>();
        symbolCoordinate = new ArrayList<>();
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
                    symbolCoordinate.add(new Coordinate(col, row));
                    symbols.add(new Symbol(new Coordinate(col, row), currentItem ));

                }
            }
            if (startCoordinate != null) {
                int number = Integer.parseInt(stringBuilder.toString());
                engineParts.add(new EnginePart(startCoordinate, new Coordinate(rawSchematic.get(row).size() - 1, row), number));
            }

        }
    }

    public List<EnginePart> getAdjacentEngineParts() {
        var symbolCoordinates = symbols.stream().map(Symbol::getCoordinate).toList();
        List<EnginePart> adjacentParts = engineParts.stream().filter(e -> e.isAdjacentToAny(symbolCoordinates)).toList();
        return adjacentParts;
    }

    public long computeGearRatios(){
        var nonGearSymbols = symbols.stream().filter(symbol -> !symbol.isGear(engineParts)).map(Symbol::getCoordinate).toList();
        var gearSymbols = symbols.stream().filter(symbol -> symbol.isGear(engineParts)).toList();
        List<EnginePart> gearParts = engineParts.stream().filter(e -> !e.isAdjacentToAny(nonGearSymbols)).toList();

        Map<Symbol, List<EnginePart>> gearmap = new HashMap<>();
        for (Symbol s : gearSymbols){
            gearmap.put(s, gearParts.stream().filter(e -> e.isAdjacent(s.getCoordinate())).toList());
        }
        long gearTotal = gearmap.entrySet().stream()
                .map(e -> e.getValue().get(0).getNumber() * e.getValue().get(1).getNumber())
                .mapToLong(Long::valueOf).sum();

        return gearTotal;
    }
}
