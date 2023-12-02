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
                Arguments.of("7pqrstsixteen", "76"));
    }

    @Test
    void partTwoTestSum() {
        Stream<Arguments> args = partTwoTestData();
        var l = args.map(Arguments::get).map(o -> (String) o[0]).toList();
        assertEquals(281, Day_1.sumPartTwo(l));
    }

    @ParameterizedTest
    @MethodSource("partTwoAdditionalTestData")
    void testPartTwoAdditionalData(String input, String expected)
    {
        assertEquals(expected, Day_1.partTwo(input));
    }

    @Test
    void testAllOccurences()
    {
        var indexes = Day_1.findAllOccurences("nineonenineonenine", "nine");
        assertEquals(3, indexes.size());
    }

    private static Stream<Arguments> partTwoAdditionalTestData()
    {
        return Stream.of(
                Arguments.of("18sixlone", "11"),
                Arguments.of("6twodndmhcgxlgbqbqndbbthnngblfgtzh5fouroneightrjp", "68"),
                Arguments.of("oneight", "18"),
                Arguments.of("85sevenfivesixslkjbninefournine", "89"),
                Arguments.of("seven98", "78"),
                Arguments.of("444lxgckhmhxd19ngrhftc", "49"),
                Arguments.of("six4two9", "69"),
                Arguments.of("fourthreerqcnchsfourthreefourgghcmcjvfv4", "44"),
                Arguments.of("vd6seven946h", "66"),
                Arguments.of("6vzpjhtwonemc", "61"),
                Arguments.of("33sevenmggst", "37"),
                Arguments.of("nine67", "97"),
                Arguments.of("two5five895ccsxdphn4", "24"),
                Arguments.of("768", "78"),
                Arguments.of("33sevenmggst", "37"),
                Arguments.of("33sevenmggst", "37"),
                Arguments.of("33sevenmggst", "37"),
                Arguments.of("33sevenmggst", "37"),
                Arguments.of("33sevenmggst", "37"),
                Arguments.of("1twooneone1four", "14"));
    }

    @Test
    public void run()
    {
        System.out.println(Day_1.runPartTwo("input.txt"));
    }
}
