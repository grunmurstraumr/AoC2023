package se.eg.aoc.day6;

import se.eg.aoc.util.FileReader;

import java.util.*;

import static java.util.function.Predicate.not;

public class Day6Part2 {

    Race race;

    public static Day6Part2 fromFile(String filename){
        Day6Part2 day6 = new Day6Part2();
        var lines = FileReader.readInputFile(filename);
        long time = 0L;
        long distance = 0L;
        for (String line : lines){
            String[] split = line.split(":");
            if (split[0].startsWith("Time")){
                time = parseValue(split[1]);
            }
            else if(split[0].startsWith("Distance")){
                distance = parseValue(split[1]);
            }
        }
        day6.race = new Race(time, distance);
        return day6;
    }

    static long parseValue(String timesString){
        return Long.valueOf(timesString.replace(" ", "").strip());
    }

    long bruteForcePartTwo(){
        long solutionsCounter = 0L;
        for (long i = 0; i < race.getTime(); i++){
            long buttonHold = DistanceOverTime.distanceOverTime(i, race.getTime());
            if (buttonHold > race.getDistance()){
                solutionsCounter++;
            }
        }
        return solutionsCounter;
    }

}
