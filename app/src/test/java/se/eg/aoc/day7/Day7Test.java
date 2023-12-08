package se.eg.aoc.day7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Day7Test {

    @Test
    void runDay7Test(){
        Day7 day7 = Day7.fromFile("day7_testInput.txt");
        assertEquals(6440L, day7.getTotalWinnings());
    }

    @Test
    void runDay7(){
        Day7 day7 = Day7.fromFile("day7.txt");
        long totalWinnings = day7.getTotalWinnings();
        assertTrue(248352776L < totalWinnings);
        System.out.println(totalWinnings);
    }

    @Test
    void runDay7Part2Test(){
        Day7part2 day7 = Day7part2.fromFile("day7_testInput.txt");
        assertEquals(5905L, day7.getTotalWinnings());
    }

    @Test
    void runDay7Part2(){
        Day7part2 day7 = Day7part2.fromFile("day7.txt");
        long totalWinnings = day7.getTotalWinnings();
        System.out.println(totalWinnings);
    }
}
