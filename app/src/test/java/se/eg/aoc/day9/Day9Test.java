package se.eg.aoc.day9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day9Test {

    @Test
    void testPartOne(){
        Day9 day9 = Day9.fromFile("day9_testInput.txt");
        assertEquals(114L,day9.runPartOne());
    }

    @Test
    void runPartOne(){
        Day9 day9 = Day9.fromFile("day9.txt");
        System.out.println(day9.runPartOne());
    }

    @Test
    void testPartTwo(){
        Day9 day9 = Day9.fromFile("day9_part2_testInput.txt");
        assertEquals(5L,day9.runPartTwo());
    }

    @Test
    void runPartTwo(){
        Day9 day9 = Day9.fromFile("day9.txt");
        System.out.println(day9.runPartTwo());
    }
}
