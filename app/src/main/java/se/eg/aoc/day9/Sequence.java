package se.eg.aoc.day9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Sequence {
    private List<Long> originalSequence;

    public Sequence(List<Long> originalSequence) {
        this.originalSequence = new ArrayList<>(originalSequence);
    }


    List<List<Long>> computSequences(){
        List<List<Long>> sequences = new LinkedList<>();
        sequences.add(originalSequence);
        List<Long> nextSequence = diffSequence(originalSequence);
        sequences.add(nextSequence);
        while (!nextSequence.stream().allMatch(n -> n == 0L)){
            nextSequence = diffSequence(nextSequence);
            sequences.add(nextSequence);

        }
        return sequences;
    }

    List<Long> diffSequence(List<Long> sequence){
        List<Long> differences = new ArrayList<>();
        for (int i = 1; i < sequence.size(); i++){
            differences.add(sequence.get(i) - sequence.get(i-1));
        }
        return differences;
    }

    static Long extrapolateNext(List<List<Long>> sequences){
        sequences.getLast().add(0L);
        for (int i = sequences.size() -1; i > 0; i--){
            var lastSequence = sequences.get(i);
            var secondToLast = sequences.get(i - 1);
            secondToLast.add(secondToLast.getLast() + lastSequence.getLast());
        }
        return sequences.getFirst().getLast();
    }

    static Long extrapolateHistory(List<List<Long>> sequences){
        sequences.getLast().add(0,0L);
        for (int i = sequences.size() -1; i > 0; i--){
            var lastSequence = sequences.get(i);
            var secondToLast = sequences.get(i - 1);
            secondToLast.add(0, secondToLast.getFirst() - lastSequence.getFirst());
        }
        var returnVal = sequences.getFirst().getFirst();
        return returnVal;
    }

}
