package se.eg.aoc.util;

import se.eg.aoc.Day_1;
import se.eg.aoc.day2.Day_2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class FileReader {
    public static List<String> readInputFile(String filename) {
        List<String> lines;
        try {
            Day_2.class.getClassLoader().getResource(filename).toURI();
            return Files.readAllLines(Path.of(Day_1.class.getClassLoader().getResource(filename).toURI()));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
