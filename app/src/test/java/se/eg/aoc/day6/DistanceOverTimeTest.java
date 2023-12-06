package se.eg.aoc.day6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistanceOverTimeTest {
    @ParameterizedTest
    @MethodSource("distanceOverTimeTestData")
    void distanceOverTimeTest(long buttonHeldMs, long raceTimeMs, long expectedDistance){
        assertEquals(expectedDistance, DistanceOverTime.distanceOverTime(buttonHeldMs, raceTimeMs));
    }
    
    static Stream<Arguments> distanceOverTimeTestData(){
        return Stream.of(
                Arguments.of(0L, 7L, 0L),
                Arguments.of(1L, 7L, 6L),
                Arguments.of(2L, 7L, 10L),
                Arguments.of(3L, 7L, 12L),
                Arguments.of(4L, 7L, 12L),
                Arguments.of(5L, 7L, 10L),
                Arguments.of(6L, 7L, 6L),
                Arguments.of(7L, 7L, 0L)
        );
    }

}
