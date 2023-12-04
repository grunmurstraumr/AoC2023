package se.eg.aoc.day2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CubeSetTest {

    @ParameterizedTest
    @MethodSource("cubeSetInput")
    void testFromString(String input, Map<CubeColor, Integer> expectedCounts) {
        var instance = CubeSet.fromString(input);
        for (var entry : expectedCounts.entrySet())
        {
            assertEquals(entry.getValue(), instance.getColourCount(entry.getKey()));
        }
    }

    static Stream<Arguments> cubeSetInput(){
        return Stream.of(
                Arguments.of("3 blue, 4 red", Map.of(CubeColor.BLUE, 3, CubeColor.RED, 4)),
                Arguments.of("1 red, 2 green, 6 blue", Map.of(CubeColor.RED, 1, CubeColor.GREEN, 2 , CubeColor.BLUE, 6)),
                Arguments.of("2 green", Map.of(CubeColor.GREEN, 2 )),
                Arguments.of("8 green, 6 blue, 20 red", Map.of(CubeColor.RED, 20, CubeColor.GREEN, 8 , CubeColor.BLUE, 6)));
    }
}
