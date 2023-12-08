package se.eg.aoc.day7.part2;

import se.eg.aoc.day7.part1.CardValue;

public class CardPart2 {
    CardValuePart2 value;

    public CardPart2() {
    }

    public CardPart2(CardValuePart2 value) {
        this.value = value;
    }

    static CardPart2 fromString(String symbol){
        CardPart2 card = new CardPart2();
        card.value = CardValuePart2.fromSymbol(symbol.strip());
        return card;
    }

    public CardValuePart2 getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                '}';
    }
}
