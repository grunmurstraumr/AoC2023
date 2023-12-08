package se.eg.aoc.day7.part2;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum CardValuePart2 {

    JOKER(0, "J"), ONE(1,"1"), TWO(2, "2"), THREE(3, "3"), FOUR(4, "4"),
    FIVE(5, "5"), SIX(6, "6"), SEVEN(7, "7"), EIGHT(8, "8"),
    NINE(9, "9"),  TEN(10, "T"),  QUEEN(11, "Q"),
    KING(12, "K"), ACE(13, "A");
    int strength;
    String symbol;

    public static final Map<String, CardValuePart2> SYMBOL_MAP = Arrays.asList(CardValuePart2.values()).stream()
            .collect(Collectors.toMap(CardValuePart2::getSymbol, Function.identity()));

    CardValuePart2(int strength, String symbol) {
        this.strength = strength;
        this.symbol = symbol;
    }

    public int getStrength() {
        return strength;
    }

    public String getSymbol() {
        return symbol;
    }

    public static CardValuePart2 fromSymbol(String symbol){
        return SYMBOL_MAP.get(symbol);
    }

}
