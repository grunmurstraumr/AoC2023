package se.eg.aoc.day7.part1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Hand implements Comparable<Hand>{
    private final List<Card> cards;

    private static final int HAND_SIZE = 5;

    private HandType handType;

    private Hand() {
        cards = new ArrayList<>(5);
    }

    public static Hand fromString(String cardString){
        Hand hand = new Hand();
        for (String card : cardString.strip().split("")){
            hand.cards.add(Card.fromString(card));
        }
        hand.handType = HandType.fromCards(hand.cards);
        return hand;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hand hand = (Hand) o;
        return this.compareTo(hand) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards);
    }

    @Override
    public int compareTo(Hand o) {
        if (handType == o.handType){
            for (int i = 0; i < this.cards.size(); i++){
                if (this.cards.get(i).getValue().getStrength() != o.cards.get(i).getValue().getStrength()){
                    return this.cards.get(i).getValue().getStrength() < o.cards.get(i).getValue().getStrength() ? -1 : 1;
                }
            }
        }
        return this.handType.compareTo(o.handType);
    }

    @Override
    public String toString() {
        return cards.stream().map(Card::getValue).map(CardValue::getSymbol).collect(Collectors.joining());
    }
}
