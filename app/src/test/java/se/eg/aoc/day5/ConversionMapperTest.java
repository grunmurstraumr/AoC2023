package se.eg.aoc.day5;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConversionMapperTest {

    @Test
    void test(){
        ConversionMapper cm = new ConversionMapper(50, 98, 2);
        assertEquals(50, cm.mapFromSource(98));
        assertEquals(51, cm.mapFromSource(99));
    }
}
