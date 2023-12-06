package se.eg.aoc.day6;

public class Race {
    private final long time;
    private final long distance;

    public Race(long time, long distance) {
        this.time = time;
        this.distance = distance;
    }



    public long getTime() {
        return time;
    }

    public long getDistance() {
        return distance;
    }
}
