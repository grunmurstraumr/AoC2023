package se.eg.aoc.day4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day4Test {

    @Test
    void runDay4Test(){
        Day4 day4 = Day4.fromFile("day4_test_input.txt");
        assertEquals(13, day4.getTotalScore());
    }

    @Test
    void runDay4(){
        Day4 day4 = Day4.fromFile("day4.txt");
        System.out.println(day4.getTotalScore());
    }

    @Test
    void runDay4BTest(){
        Day4 day4 = Day4.fromFile("day4_test_input.txt");
        assertEquals(30, day4.totalNumberOfScratchCards());
    }

    @Test
    void runDay4B(){
        Day4 day4 = Day4.fromFile("day4.txt");
        System.out.println(day4.totalNumberOfScratchCards());
    }
}
