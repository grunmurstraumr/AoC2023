package se.eg.aoc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day_1Test {

    @ParameterizedTest
    @MethodSource("testData")
    void testWithTestData(String input, String expected) {
        assertEquals(expected, Day_1.partOne(input));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("1abc2", "12"),
                Arguments.of("pqr3stu8vwx", "38"),
                Arguments.of("a1b2c3d4e5f", "15"),
                Arguments.of("treb7uchet", "77"));
    }

    @ParameterizedTest
    @MethodSource("partTwoTestData")
    void testPartTwo(String input, String expected)
    {
        assertEquals(expected, Day_1.partTwo(input));
    }

    private static Stream<Arguments> partTwoTestData() {
        return Stream.of(
                Arguments.of("two1nine", "29"),
                Arguments.of("eightwothree", "83"),
                Arguments.of("abcone2threexyz", "13"),
                Arguments.of("xtwone3four", "24"),
                Arguments.of("4nineeightseven2", "42"),
                Arguments.of("zoneight234", "14"),
                Arguments.of("7pqrstsixteen", "76"),
                Arguments.of("18sixlone", "11"),
                Arguments.of("6twodndmhcgxlgbqbqndbbthnngblfgtzh5fouroneightrjp", "68"),
                Arguments.of("oneight", "18"));
    }
    @Test
    public void run()
    {
        System.out.println(Day_1.runPartTwo("input.txt"));
    }
}
