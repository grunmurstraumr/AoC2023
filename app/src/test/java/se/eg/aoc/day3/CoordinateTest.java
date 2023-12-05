package se.eg.aoc.day3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoordinateTest {

    @ParameterizedTest
    @MethodSource("adjacentCoorinates")
    void testAdjacentCoordinates(Coordinate a, Coordinate b){
        assertTrue(a.isAdjacent(b));
    }

    static Stream<Arguments> adjacentCoorinates(){
        return Stream.of(
                Arguments.of(new Coordinate(2, 2), new Coordinate(1,1)),
                Arguments.of(new Coordinate(2,2), new Coordinate(1,2)),
                Arguments.of(new Coordinate(2,2), new Coordinate(1,3)),
                Arguments.of(new Coordinate(2,2), new Coordinate(2,1)),
                Arguments.of(new Coordinate(2,2), new Coordinate(3,1)),
                Arguments.of(new Coordinate(2,2), new Coordinate(2,3)),
                Arguments.of(new Coordinate(2,2), new Coordinate(3,3)),
                Arguments.of(new Coordinate(0, 2), new Coordinate(1,3)),
                Arguments.of(new Coordinate(2, 4), new Coordinate(3,4))
        );
    }

    @ParameterizedTest
    @MethodSource("nonAdjacentCoorinates")
    void testNonAdjacentCoordinates(Coordinate a, Coordinate b){
        assertFalse(a.isAdjacent(b));
    }

    static Stream<Arguments> nonAdjacentCoorinates(){
        return Stream.of(
                Arguments.of(new Coordinate(3, 3), new Coordinate(1,1)),
                Arguments.of(new Coordinate(3,3), new Coordinate(1,2)),
                Arguments.of(new Coordinate(3,3), new Coordinate(1,3)),
                Arguments.of(new Coordinate(3,3), new Coordinate(1,4)),
                Arguments.of(new Coordinate(3,3), new Coordinate(1,5)),
                Arguments.of(new Coordinate(3,3), new Coordinate(2,1)),
                Arguments.of(new Coordinate(3,3), new Coordinate(3,1)),
                Arguments.of(new Coordinate(3,3), new Coordinate(4,1)),
                Arguments.of(new Coordinate(3,3), new Coordinate(5,1)),
                Arguments.of(new Coordinate(3,3), new Coordinate(5,5)),
                Arguments.of(new Coordinate(3,3), new Coordinate(5,4)),
                Arguments.of(new Coordinate(3,3), new Coordinate(5,3)),
                Arguments.of(new Coordinate(3,3), new Coordinate(5,2)),
                Arguments.of(new Coordinate(3,3), new Coordinate(5,1)),
                Arguments.of(new Coordinate(3,3), new Coordinate(4,5)),
                Arguments.of(new Coordinate(3,3), new Coordinate(3,5)),
                Arguments.of(new Coordinate(3,3), new Coordinate(2,5)),
                Arguments.of(new Coordinate(3,3), new Coordinate(1,5))
        );
    }

    @Test
    void isAdjacentX(){
        Coordinate a = new Coordinate(2,0);
        assertTrue(a.isAdjacentX(new Coordinate(1, 0)));
        assertTrue(a.isAdjacentX(new Coordinate(3, 0)));
    }

    @Test
    void isAdjacentY(){
        Coordinate a = new Coordinate(0,2);
        assertTrue(a.isAdjacentY(new Coordinate(0, 1)));
        assertTrue(a.isAdjacentY(new Coordinate(0, 3)));
    }

    @Test
    void isAdjacentDiagonal(){
        Coordinate a = new Coordinate(2,2);
        assertTrue(a.isAdjacent(new Coordinate(1,1)));
        assertTrue(a.isAdjacent(new Coordinate(3,3)));
        assertTrue(a.isAdjacent(new Coordinate(1,3)));
        assertTrue(a.isAdjacent(new Coordinate(3,1)));
    }
}
