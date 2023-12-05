package se.eg.aoc.day5;

public class ConversionMapper {

    Range destinationRange;
    Range sourceRange;

    public ConversionMapper(long destinationRangeStart, long sourceRangeStart,  long rangeLength) {
        destinationRange = new Range(destinationRangeStart, rangeLength);
        sourceRange = new Range(sourceRangeStart, rangeLength);
    }

    long mapFromSource(long sourceNumber){
        if (!sourceRange.withinRange(sourceNumber))
            return -1;
        long position = sourceRange.positionInRange(sourceNumber);
        return destinationRange.numberFromPosition(position);
    }



}
