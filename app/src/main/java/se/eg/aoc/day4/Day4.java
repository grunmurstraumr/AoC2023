package se.eg.aoc.day4;

import se.eg.aoc.util.FileReader;

import java.util.*;

public class Day4 {
    List<Card> originalCards;

    static Day4 fromFile(String filename) {
        Day4 instance = new Day4();
        List<String> lines = FileReader.readInputFile(filename);
        instance.originalCards = lines.stream().map(Card::fromString).toList();
        return instance;
    }

    public long totalNumberOfScratchCards() {
        Map<Card, Long> winsPerCard = new HashMap<>();
        SortedMap<Card, Long> totalScratchCards = new TreeMap<>(Comparator.comparingLong(Card::getId)); // Mapping cards to counts
        for (Card card : originalCards) {
            totalScratchCards.put(card, 1L);
        }
        for (int i = 0; i < originalCards.size(); i++) {
            Card card = originalCards.get(i);
            long cardCount = totalScratchCards.get(card);
            long wins = card.wins();
            for (int counter = 0; counter < totalScratchCards.get(card); counter++) {
                for (int j = i + 1; j < i + wins + 1 && j < originalCards.size(); j++) {
                    Long count = totalScratchCards.get(originalCards.get(j));
                    count++;
                    totalScratchCards.put(originalCards.get(j), count);
                }
            }
        }

        return totalScratchCards.values().stream().mapToLong(Long::longValue).sum();
    }

    long getTotalScore() {
        return originalCards.stream().mapToLong(Card::computeScore).sum();
    }
}
