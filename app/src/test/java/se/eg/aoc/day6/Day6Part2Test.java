package se.eg.aoc.day6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day6Part2Test {

    @Test
    void runDay6Test(){
        Day6Part2 day6 = Day6Part2.fromFile("day6_testInput.txt");
        assertEquals(71503, day6.bruteForcePartTwo());
    }

    @Test
    void runDay6PartOne(){
        Day6Part2 day6 = Day6Part2.fromFile("day6.txt");
        System.out.println(day6.bruteForcePartTwo());
    }
}
