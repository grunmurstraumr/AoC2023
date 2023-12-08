package se.eg.aoc.day7;

import se.eg.aoc.day7.part1.Hand;
import se.eg.aoc.util.FileReader;

import java.util.*;

public class Day7 {

    SortedMap<Hand, Long> handBetMapping;

    static Day7 fromFile(String filename){
        Day7 day7 = new Day7();
        day7.handBetMapping = new TreeMap<>();
        var lines = FileReader.readInputFile(filename);
        for (var line : lines){
            String[] split = line.split(" ");
            day7.handBetMapping.put(Hand.fromString(split[0].trim()), Long.parseLong(split[1].trim()));
        }
        return day7;
    }

    long getTotalWinnings(){
        long total = 0;
        var sortedBetsMap = handBetMapping.values().stream().toList();
        for (int i = 1; i < sortedBetsMap.size() + 1; i++){
            total += sortedBetsMap.get(i-1) * i;
        }
        return total;
    }
}
