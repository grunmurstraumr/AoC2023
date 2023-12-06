package se.eg.aoc.day6;

public class DistanceOverTime {

    public static long distanceOverTime(long buttonHeldms, long timems){
        return buttonHeldms * (timems - buttonHeldms);

    }

}
