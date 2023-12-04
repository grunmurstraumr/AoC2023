package se.eg.aoc.day2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {


    @ParameterizedTest
    @MethodSource("gameStringTotalsSource")
    void testGameFromStringTotal(String input, Map<CubeColor, Integer> expectedTotals)
    {
        Game instance = Game.fromLine(input);
        assertEquals(expectedTotals, instance.getTotals());
    }
    static Stream<Arguments> gameStringTotalsSource(){
        return Stream.of(
                Arguments.of("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
                        Map.of(CubeColor.BLUE, 9, CubeColor.RED, 5, CubeColor.GREEN, 4 )),
                Arguments.of("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
                        Map.of(CubeColor.BLUE, 6, CubeColor.RED, 1, CubeColor.GREEN, 6 )),
                Arguments.of("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
                        Map.of(CubeColor.BLUE, 11, CubeColor.RED, 25, CubeColor.GREEN, 26 )),
                Arguments.of("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
                        Map.of(CubeColor.BLUE, 21, CubeColor.RED, 23, CubeColor.GREEN, 7 )),
                Arguments.of("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green",
                        Map.of(CubeColor.BLUE, 3, CubeColor.RED, 7, CubeColor.GREEN, 5 ))
        );
    }

    @ParameterizedTest
    @MethodSource("gameStringMaxSource")
    void testGameFromStringMax(String input, Map<CubeColor, Integer> expectedTotals)
    {
        Game instance = Game.fromLine(input);
        assertEquals(expectedTotals, instance.getMaxes());
    }
    static Stream<Arguments> gameStringMaxSource(){
        return Stream.of(
                Arguments.of("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
                        Map.of(CubeColor.BLUE, 6, CubeColor.RED, 4, CubeColor.GREEN, 2 )),
                Arguments.of("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
                        Map.of(CubeColor.BLUE, 4, CubeColor.RED, 1, CubeColor.GREEN, 3 )),
                Arguments.of("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
                        Map.of(CubeColor.BLUE, 6, CubeColor.RED, 20, CubeColor.GREEN, 13 )),
                Arguments.of("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
                        Map.of(CubeColor.BLUE, 15, CubeColor.RED, 14, CubeColor.GREEN, 3 )),
                Arguments.of("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green",
                        Map.of(CubeColor.BLUE, 2, CubeColor.RED, 6, CubeColor.GREEN, 3 ))
        );
    }

    @ParameterizedTest
    @MethodSource("gameStringPossible")
    void testGameFromStringPossible(String input, CubeSet cubeset, boolean possible){
        Game instance = Game.fromLine(input);
        assertEquals(possible, instance.isPossible(cubeset));
    }
    static Stream<Arguments> gameStringPossible(){
        CubeSet cs = CubeSet.fromString("12 red, 13 green, 14 blue");
        return Stream.of(
                Arguments.of("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
                        cs, true),
                Arguments.of("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
                        cs, true),
                Arguments.of("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
                        cs, false),
                Arguments.of("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
                        cs, false),
                Arguments.of("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green",
                        cs, true)
        );
    }

    @ParameterizedTest
    @MethodSource("powerInput")
    void testGameFromStringPossible(String input, int power){
        Game instance = Game.fromLine(input);
        assertEquals(power, instance.calculateMinumCubePower());
    }

    static Stream<Arguments> powerInput(){
        return Stream.of(
                Arguments.of("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
                        48),
                Arguments.of("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
                        12),
                Arguments.of("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
                        1560),
                Arguments.of("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
                        630),
                Arguments.of("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green",
                        36)
        );
    }
}
