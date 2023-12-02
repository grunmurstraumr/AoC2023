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

    private static final Map<String, String> DIGITS = new HashMap<>();
    static {
        for (Integer i = 1; i < 10; i++) {
            DIGITS.put(i.toString(), i.toString());
        }
        DIGITS.put("one", "1");
        DIGITS.put("two", "2");
        DIGITS.put("three", "3");
        DIGITS.put("four", "4");
        DIGITS.put("five", "5");
        DIGITS.put("six", "6");
        DIGITS.put("seven", "7");
        DIGITS.put("eight", "8");
        DIGITS.put("nine", "9");
    }

    public static String partOne(String input) {
        List<String> digits = Arrays.stream(input.split("")).filter(s -> isDigit(s.charAt(0))).toList();
        return digits.getFirst() + digits.getLast();
    }

    public static int runPartOne(String filename) {
        List<String> lines;
        try {
            Day_1.class.getClassLoader().getResource(filename).toURI();
            lines = Files.readAllLines(Path.of(Day_1.class.getClassLoader().getResource(filename).toURI()));
            return lines.stream().map(Day_1::partOne).mapToInt(Integer::parseInt).sum();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public static String partTwo(String input) {
        int ithMatch = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            Optional<Map<String, Integer>> digit = findIthMatchingKey(input, ithMatch);
            if (digit.isEmpty())
                break;
            String s = digit.get().keySet().stream().findFirst().get();
            int index = digit.get().values().stream().findFirst().get();
            sb.append(DIGITS.get(s));
//            input = input.substring(0, index ) + input.substring(index + s.length());
            ithMatch++;
        }
        List<String> digits = List.of(sb.toString().split(""));
        String returnValue = digits.getFirst() + digits.getLast();
        return returnValue;
    }

    private static Optional<Map<String, Integer>> findIthMatchingKey(String input, int i) {
        SortedMap<Integer, String> matchIndex = new TreeMap<>();
        for (String key : DIGITS.keySet()) {
            List<Integer> indexes = findAllOccurences(input, key);
            if (!indexes.isEmpty()) {
                indexes.forEach(index -> matchIndex.put(index, key));
            }
        }
        if (matchIndex.isEmpty()) {
            return Optional.empty();
        }

        if (i >= matchIndex.size()) {
            return Optional.empty();
        }
        var value = (Map.Entry<Integer, String>) matchIndex.entrySet().toArray()[i];
        return Optional.of(Map.of(value.getValue(), value.getKey()));
    }

    static List<Integer> findAllOccurences(String input, String target) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < input.length() - target.length() + 1; i++){
            if (target.equals(input.substring(i, i + target.length()))){
                indexes.add(i);
            }
        }
        return indexes;
    }

    public static int runPartTwo(String filename) {
        List<String> lines;
        try {
            Day_1.class.getClassLoader().getResource(filename).toURI();
            lines = Files.readAllLines(Path.of(Day_1.class.getClassLoader().getResource(filename).toURI()));
            return sumPartTwo(lines);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return 0;
    }

    static int sumPartTwo(List<String> input)
    {
        return input.stream().map(Day_1::partTwo).mapToInt(Integer::parseInt).sum();
    }
}
