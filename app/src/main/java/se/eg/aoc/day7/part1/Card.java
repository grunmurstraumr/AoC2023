package se.eg.aoc.day7.part1;

public class Card {
    CardValue value;

    static Card fromString(String symbol){
        Card card = new Card();
        card.value = CardValue.fromSymbol(symbol.strip());
        return card;
    }

    public CardValue getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                '}';
    }
}
