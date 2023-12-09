package se.eg.aoc.day9;

import se.eg.aoc.util.FileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public class Day9 {

    List<Sequence> sequenceList;

    public Day9() {
        this.sequenceList = new ArrayList<>();
    }

    static Day9 fromFile(String filename){
        Day9 day = new Day9();
        for (String line : FileReader.readInputFile(filename)){
            List<Long> sequence =Arrays.stream(line.split(" ")).filter(not(String::isBlank)).map(String::strip).map(Long::valueOf).toList();
            day.sequenceList.add(new Sequence(sequence));
        }
        return day;
    }

    long runPartOne(){
        return this.sequenceList.stream().map(Sequence::computSequences).mapToLong(Sequence::extrapolateNext).sum();
    }

    long runPartTwo(){
        return this.sequenceList.stream().map(Sequence::computSequences).mapToLong(Sequence::extrapolateHistory).sum();
    }

}
