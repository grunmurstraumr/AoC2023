package se.eg.aoc.day7.part1;

import java.util.*;
import java.util.stream.Collectors;

public enum HandType {
    HIGH_CARD, ONE_PAIR, TWO_PAIR, THREE_OF_A_KIND, FULL_HOUSE, FOUR_OF_A_KIND, FIVE_OF_A_KIND;

    static HandType fromCards(List<Card> cards){
        Map<CardValue, Integer> cardValueCount = new HashMap<>();
        Set<CardValue> cardValueSet = cards.stream().map(Card::getValue).collect(Collectors.toSet());

        for (Card card : cards){
            if (cardValueCount.containsKey(card.getValue())){
                cardValueCount.put(card.getValue(), cardValueCount.get(card.getValue()) + 1);
            }
            else {
                cardValueCount.put(card.getValue(), 1);
            }
        }
        List<Integer> sortedList = cardValueCount.values().stream().sorted((a, b) -> -1 * a.compareTo(b)).toList();

        if (sortedList.get(0) == 5){
            return FIVE_OF_A_KIND;
        }

        if (sortedList.get(0) == 4){
            return FOUR_OF_A_KIND;
        }
        if ( sortedList.get(0) == 3){
            if (sortedList.get(1) == 2){
                return FULL_HOUSE;
            }
            else {
                return THREE_OF_A_KIND;
            }
        }
        if (sortedList.get(0) == 2){
            if (sortedList.get(1) == 2){
                return TWO_PAIR;
            }
            else {
                return ONE_PAIR;
            }
        }
    return HIGH_CARD;
    }
}
