package se.eg.aoc.day5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day5Test {

    @Test
    void runDay5Test(){
        Day5 day5 = Day5.fromFile("day5_testInput.txt");
        assertEquals(35, day5.findLowestLocationNumberFromSeeds());
    }

    @Test
    void runDay5(){
        Day5 day5 = Day5.fromFile("day5.txt");
        System.out.println(day5.findLowestLocationNumberFromSeeds());
    }
}
