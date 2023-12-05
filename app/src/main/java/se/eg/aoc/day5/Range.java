package se.eg.aoc.day5;

public class Range {
    long start;
    long endInclusive;

    private static final long oneIndexedOffset = 1;
    public Range(long start, long range) {
        this.start = start;
        this.endInclusive = start + range -oneIndexedOffset;
    }

    long positionInRange(long number) {
        if (number < start || number > endInclusive) {
            return -1;
        }
        return number - start + oneIndexedOffset;
    }

    long numberFromPosition(long positionInRange){
        return start + positionInRange -oneIndexedOffset;
    }

    boolean withinRange(long number){
        return start <= number && number <= endInclusive;
    }
}
