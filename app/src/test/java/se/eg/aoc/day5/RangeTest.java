package se.eg.aoc.day5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RangeTest {

    @Test
    void testRange(){
        Range r = new Range(50, 2);
        assertEquals(1, r.positionInRange(50));
        assertEquals(2, r.positionInRange(51));

        // outside range
        assertEquals(-1, r.positionInRange(49));
        assertEquals(-1, r.positionInRange(52));

        assertEquals(50, r.numberFromPosition(1));
        assertEquals(51, r.numberFromPosition(2));
    }
}
