package se.eg.aoc.day7.part2;

import java.util.*;
import java.util.stream.Collectors;

public class HandPart2 implements Comparable<HandPart2>{
    private final List<CardPart2> originalCards;

    private static final int HAND_SIZE = 5;

    private HandTypePart2 handType;

    private HandPart2() {
        originalCards = new ArrayList<>(5);
    }

    public static HandPart2 fromString(String cardString){
        HandPart2 hand = new HandPart2();
        for (String card : cardString.strip().split("")){
            hand.originalCards.add(CardPart2.fromString(card));
        }
        hand.handType = HandTypePart2.fromCards(hand.originalCards);
        hand.handType = replaceJokerCards(hand.originalCards).stream().map(HandTypePart2::fromCards).sorted((a,b) -> -1 * a.compareTo(b)).toList().get(0);
        return hand;
    }

    static List<List<CardPart2>> replaceJokerCards(List<CardPart2> cards){
        Set<CardValuePart2> presentCardsValues = cards.stream().map(CardPart2::getValue).collect(Collectors.toSet());
        if (presentCardsValues.contains(CardValuePart2.JOKER)){
            // Replace all jokers with one type of value
            List<List<CardPart2>> returnVal = new ArrayList<>();
            for (CardValuePart2 cardval : presentCardsValues){
                List<CardPart2> replacedCards = cards.stream().map(c -> c.getValue() == CardValuePart2.JOKER ? new CardPart2(cardval) : c).toList();
                returnVal.add(replacedCards);
            }
            return returnVal;
        }
        return List.of(cards);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HandPart2 hand = (HandPart2) o;
        return this.compareTo(hand) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(originalCards);
    }

    @Override
    public int compareTo(HandPart2 o) {
        if (handType == o.handType){
            for (int i = 0; i < this.originalCards.size(); i++){
                if (this.originalCards.get(i).getValue().getStrength() != o.originalCards.get(i).getValue().getStrength()){
                    return this.originalCards.get(i).getValue().getStrength() < o.originalCards.get(i).getValue().getStrength() ? -1 : 1;
                }
            }
        }
        return this.handType.compareTo(o.handType);
    }

    @Override
    public String toString() {
        return originalCards.stream().map(CardPart2::getValue).map(CardValuePart2::getSymbol).collect(Collectors.joining());
    }
}
