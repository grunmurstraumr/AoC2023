package se.eg.aoc;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;

public class Day_1 {
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
}
