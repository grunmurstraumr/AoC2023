package se.eg.aoc;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;

public class Day_1 {

    private static final Map<String, String> DIGITS = Map.of(
            "one", "1",
            "two", "2",
            "three", "3",
            "four", "4",
            "five", "5",
            "six", "6",
            "seven", "7",
            "eight", "8",
            "nine", "9"
    );

    public static String partOne(String input)
    {
        List<String> digits =  Arrays.stream(input.split("")).filter(s -> isDigit(s.charAt(0))).toList();
        return digits.getFirst() + digits.getLast();
    }

    public static int runPartOne(String filename)
    {
        List<String> lines;
        try {
            Day_1.class.getClassLoader().getResource(filename).toURI();
            lines = Files.readAllLines(Path.of(Day_1.class.getClassLoader().getResource(filename).toURI()));
            return lines.stream().map(Day_1::partOne).mapToInt(Integer::parseInt).sum();
        }
        catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public static String partTwo(String input)
    {
        while (true)
        {
            Optional<String> firstNumber = findFirstMatchingKey(input);
            if (firstNumber.isEmpty())
                break;
            input = input.replaceAll(firstNumber.get(), DIGITS.get(firstNumber.get()));
        }
        List<String> digits = Arrays.stream(input.split("")).filter(s -> isDigit(s.charAt(0))).toList();
        String returnValue = digits.getFirst() + digits.getLast();
        return returnValue;
    }

    private static Optional<String> findFirstMatchingKey(String input)
    {
        Map<Integer, String> matchIndex = new HashMap<>();
        for (String key : DIGITS.keySet())
        {
            int index = input.indexOf(key);
            if (index >= 0) {
                matchIndex.put(index, key);
            }
        }
        if (matchIndex.isEmpty()) {
            return Optional.empty();
        }
        Optional<Integer> lowestIndex = matchIndex.keySet().stream().sorted().findFirst();
        return Optional.of(matchIndex.get(lowestIndex.get()));
    }

    public static int runPartTwo(String filename)
    {
        List<String> lines;
        try {
            Day_1.class.getClassLoader().getResource(filename).toURI();
            lines = Files.readAllLines(Path.of(Day_1.class.getClassLoader().getResource(filename).toURI()));
            return lines.stream().map(Day_1::partTwo).mapToInt(Integer::parseInt).sum();
        }
        catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return 0;
    }


}
