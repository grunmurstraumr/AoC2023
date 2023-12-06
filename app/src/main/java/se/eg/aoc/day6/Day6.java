package se.eg.aoc.day6;

import org.checkerframework.checker.units.qual.A;
import se.eg.aoc.util.FileReader;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

public class Day6 {

    List<Race> races;

    public Day6() {
        races = new ArrayList<>();
    }

    public static Day6 fromFile(String filename){
        Day6 day6 = new Day6();
        var lines = FileReader.readInputFile(filename);
        List<Long> times = Collections.emptyList();
        List<Long> distances = Collections.emptyList();
        for (String line : lines){
            String[] split = line.split(":");
            if (split[0].startsWith("Time")){
                times = parseValues(split[1]);
            }
            else if(split[0].startsWith("Distance")){
                distances = parseValues(split[1]);
            }
        }

        for (int i = 0; i < times.size(); i++){
           day6.races.add(new Race(times.get(i), distances.get(i)));
        }

        return day6;
    }

    static List<Long> parseValues(String timesString){
        String[] individualTimes = timesString.strip().split(" ");
        return Arrays.stream(individualTimes).map(String::trim).filter(not(String::isBlank)).map(Long::valueOf).toList();
    }

    long bruteForcePartOne(){
        Map<Race, Long> raceSolutionsMap = new HashMap<>();
        for (Race race : races){
            List<Long> solutions = new ArrayList<>();
            for (long i = 0; i < race.getTime(); i++){
                long buttonHold = DistanceOverTime.distanceOverTime(i, race.getTime());
                if (buttonHold > race.getDistance()){
                    solutions.add(buttonHold);
                }
            }
            raceSolutionsMap.put(race, (long) solutions.size());
        }
        long product = raceSolutionsMap.values().stream().reduce(1L, (a, b) -> a * b );
        return product;
    }

}
