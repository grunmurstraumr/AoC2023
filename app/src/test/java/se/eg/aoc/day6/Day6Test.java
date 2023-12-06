package se.eg.aoc.day6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day6Test {
    @Test
    void runDay6Test(){
        Day6 day6 = Day6.fromFile("day6_testInput.txt");
        assertEquals(288, day6.bruteForcePartOne());
    }

    @Test
    void runDay6PartOne(){
        Day6 day6 = Day6.fromFile("day6.txt");
        System.out.println(day6.bruteForcePartOne());
    }
}
