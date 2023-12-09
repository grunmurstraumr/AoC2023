package se.eg.aoc.day8;

import org.checkerframework.checker.units.qual.N;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day8Test {

    @Test
    void runDay8Test(){
        Network network = Network.fromFile("day8_testInput.txt");
        assertEquals(2, network.stepsToReachDestination("AAA", "ZZZ"));
    }

    @Test
    void runDay8TestSecond(){
        Network network = Network.fromFile("day8_testInputSecondExample.txt");
        assertEquals(6, network.stepsToReachDestination("AAA", "ZZZ"));
    }

    @Test
    void runDay8(){
        Network network = Network.fromFile("day8.txt");
        System.out.println(network.stepsToReachDestination("AAA", "ZZZ"));
    }

    @Test
    public void testLCM() {
        Network network = new Network();
        assertEquals(36L, network.lowestCommonMultiple(Arrays.asList(12L, 18L)));
        assertEquals(36L, network.lowestCommonMultiple(Arrays.asList(3L, 4L, 6L, 12L, 18L)));
    }

    @Test
    void runDay8part2Test_bruteForece(){
        Network network = Network.fromFile("day8_part2_testInput.txt");
        assertEquals(6, network.simlutaneousStepsToReachDestination(network.findStartNodes()));
    }


    @Test
    void runDay8part2_bruteForce(){
        Network network = Network.fromFile("day8.txt");
        System.out.println(network.simlutaneousStepsToReachDestination(network.findStartNodes()));
    }

    @Test
    void runDay8part2Test_lcm(){
        Network network = Network.fromFile("day8_part2_testInput.txt");
        assertEquals(6, network.part2());
    }

    @Test
    void runDay8part2_lcm(){
        Network network = Network.fromFile("day8.txt");
        System.out.println(network.part2());
    }
}
