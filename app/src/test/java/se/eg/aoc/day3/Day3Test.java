package se.eg.aoc.day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day3Test {

    @Test
    void runDay3(){
        Schematic schematic = new Schematic();
        schematic.readFromFile("input_day3.txt");
        System.out.println(schematic.getAdjacentEngineParts().stream().mapToInt(EnginePart::getNumber).sum());
    }

    @Test
    void runDay3partTwo(){
        Schematic schematic = new Schematic();
        schematic.readFromFile("input_day3.txt");
        System.out.println(schematic.computeGearRatios());
    }
    @Test
    void runDay3Test(){
        Schematic schematic = new Schematic();
        schematic.readFromFile("Day3_testInput");
        System.out.println(schematic.getAdjacentEngineParts().stream().mapToInt(EnginePart::getNumber).sum());
    }
    @Test
    void runDay3AdditionalTest(){
        Schematic schematic = new Schematic();
        schematic.readFromFile("Day3_additional_test.txt");
        System.out.println(schematic.getAdjacentEngineParts().stream().mapToInt(EnginePart::getNumber).sum());
    }
    @Test
    void runDay3AdditionalredditTest(){
        Schematic schematic = new Schematic();
        schematic.readFromFile("reddit_testdata.txt");
        assertEquals(925, schematic.getAdjacentEngineParts().stream().mapToInt(EnginePart::getNumber).sum());
    }

    @Test
    void runDay3Part2Test(){
        Schematic schematic = new Schematic();
        schematic.readFromFile("Day3_testInput");
        long total = schematic.computeGearRatios();
        System.out.println(total);
        assertEquals(467835,total);
    }
}
