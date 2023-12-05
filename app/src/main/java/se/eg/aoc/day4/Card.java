package se.eg.aoc.day4;

import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.List;

public class Card {
    private Card() {
    }

    private long id;
    List<Long> winningNumbers;
    List<Long> numbersYouHave;

    public long getId() {
        return id;
    }

    static Card fromString(String line){
        Card instance = new Card();
        String[] split = line.split(":");
        instance.id = Long.valueOf(split[0].replace("Card", "").strip());
        String[] numbersSplit = split[1].split("\\|");

        instance.winningNumbers = new ArrayList<>();
        for (String s : numbersSplit[0].strip().split(" "))
        {
            if (s.isEmpty())
                continue;
            instance.winningNumbers.add(Long.valueOf(s));
        }
        instance.numbersYouHave = new ArrayList<>();
        for (String s : numbersSplit[1].strip().split(" "))
        {
            if (s.isEmpty())
                continue;
            instance.numbersYouHave.add(Long.valueOf(s));
        }
        return instance;
    }

    public long wins(){
        return numbersYouHave.stream().filter(winningNumbers::contains).count();
    }
    long computeScore(){
        long wins = wins();
        if (wins < 1){
            return 0;
        }
        long score = 1;
        for (int i = 1; i < wins; i++){
            score *= 2;
        }
        return score;
    }
}
