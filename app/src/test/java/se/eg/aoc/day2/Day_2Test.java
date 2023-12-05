package se.eg.aoc.day2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day_2Test {

    Day_2 day2;

    @BeforeEach
    void init(){
        day2 = new Day_2();
    }
    @Test
    void readTestFile()
    {
        var lines = day2.readInputFile("Day2_test_input.txt");
        assertEquals(5, lines.size());
    }

    @Test
    void findPossibleGames() {
        CubeSet cubeSet = CubeSet.fromString("12 red, 13 green, 14 blue");
        List<Integer> expectedPossibleIds = List.of(1,2,5);
        day2.readGamesFromFile("Day2_test_input.txt");
        assertEquals(expectedPossibleIds, day2.possibleGames(cubeSet));
    }

    @Test
    void runDay2a(){
        CubeSet cubeSet = CubeSet.fromString("12 red, 13 green, 14 blue");
        day2.readGamesFromFile("day2.txt");
        System.out.println(day2.sumPossibleGames(cubeSet));
    }

    @Test
    void sumOfPowersTest(){
        day2.readGamesFromFile("Day2_test_input.txt");
        assertEquals(2286, day2.sumOfPowers());
    }
    @Test
    void runDay2b(){
        day2.readGamesFromFile("day2.txt");
        System.out.println(day2.sumOfPowers());
    }
}
