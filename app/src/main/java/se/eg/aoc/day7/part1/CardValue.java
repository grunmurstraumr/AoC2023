package se.eg.aoc.day7.part1;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum CardValue {

    ONE(1,"1"), TWO(2, "2"), THREE(3, "3"), FOUR(4, "4"),
    FIVE(5, "5"), SIX(6, "6"), SEVEN(7, "7"), EIGHT(8, "8"),
    NINE(9, "9"),  TEN(10, "T"), JACK(11, "J"), QUEEN(12, "Q"),
    KING(13, "K"), ACE(14, "A");
    int strength;
    String symbol;

    public static final Map<String, CardValue> SYMBOL_MAP = Arrays.asList(CardValue.values()).stream()
            .collect(Collectors.toMap(CardValue::getSymbol, Function.identity()));

    CardValue(int strength, String symbol) {
        this.strength = strength;
        this.symbol = symbol;
    }

    public int getStrength() {
        return strength;
    }

    public String getSymbol() {
        return symbol;
    }

    public static CardValue fromSymbol(String symbol){
        return SYMBOL_MAP.get(symbol);
    }

    @Override
    public String toString() {
        return "CardValue{" +
                "symbol='" + symbol + '\'' +
                '}';
    }
}
