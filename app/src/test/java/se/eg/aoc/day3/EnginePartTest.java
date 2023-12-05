package se.eg.aoc.day3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnginePartTest {

    @ParameterizedTest
    @MethodSource("adjacentToAnyData")
    void isAdjacentToAnyTest(EnginePart enginePart, List<Coordinate> adjacentToEnginePart){
        assertTrue(enginePart.isAdjacentToAny(adjacentToEnginePart));
    }

    static Stream<Arguments> adjacentToAnyData()  {
        List<Coordinate> adjacentSymbols = List.of( new Coordinate(3,1), new Coordinate(6,3),
                new Coordinate(3,4), new Coordinate(5,5), new Coordinate(3, 8), new Coordinate(5,8));
        return Stream.of(
                Arguments.of(new EnginePart(new Coordinate(0, 0), new Coordinate(2, 0), 467), adjacentSymbols),
                Arguments.of(new EnginePart(new Coordinate(2, 2), new Coordinate(3, 2), 35), adjacentSymbols),
                Arguments.of(new EnginePart(new Coordinate(6, 2), new Coordinate(8, 2), 633), adjacentSymbols),
                Arguments.of(new EnginePart(new Coordinate(0, 4), new Coordinate(2, 4), 617), adjacentSymbols),
                Arguments.of(new EnginePart(new Coordinate(2, 6), new Coordinate(4, 6), 592), adjacentSymbols),
                Arguments.of(new EnginePart(new Coordinate(6, 7), new Coordinate(8, 7), 755), adjacentSymbols),
                Arguments.of(new EnginePart(new Coordinate(1, 9), new Coordinate(3, 9), 664), adjacentSymbols),
                Arguments.of(new EnginePart(new Coordinate(5, 9), new Coordinate(7, 9), 598), adjacentSymbols)
        );

    }

    @ParameterizedTest
    @MethodSource("notAdjacentToAnyData")
    void isNotAdjacentToAny(EnginePart enginePart, List<Coordinate> notAdjacentCoordinates){
        assertFalse(enginePart.isAdjacentToAny(notAdjacentCoordinates));
    }

    static Stream<Arguments> notAdjacentToAnyData()  {
        List<Coordinate> adjacentSymbols = List.of( new Coordinate(3,1), new Coordinate(6,3),
                new Coordinate(3,4), new Coordinate(5,5), new Coordinate(3, 8), new Coordinate(5,8));
        return Stream.of(
                Arguments.of(new EnginePart(new Coordinate(5, 0), new Coordinate(7, 0), 114), adjacentSymbols),
                Arguments.of(new EnginePart(new Coordinate(7, 5), new Coordinate(8, 5), 58), adjacentSymbols)
        );

    }
}
