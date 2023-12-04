package se.eg.aoc.day2;

import java.util.EnumMap;
import java.util.List;


public class CubeSet {
    EnumMap<CubeColor, Integer> colorCount;

    public CubeSet() {
        colorCount = new EnumMap<>(CubeColor.class);
    }
    public int getColourCount (CubeColor color) {
        return colorCount.getOrDefault(color, 0);
    }

    private void setColorCount(CubeColor color, int count){
        this.colorCount.put(color, count);
    }

    public static CubeSet fromString(String input) {
        var instance = new CubeSet();
        List<String> split = List.of(input.split(","));
        EnumMap<CubeColor, Integer> colourCount = new EnumMap<>(CubeColor.class);
        for (String s : split) {
            for (CubeColor color : CubeColor.values()){
                if (s.contains(color.name().toLowerCase())){
                    instance.setColorCount(color, parseCount(s, color));
                }
            }
        }
        return instance;
    }

    private static int parseCount(String input, CubeColor color) {
        return Integer.parseInt(input.replace(color.name().toLowerCase(), "").trim());
    }
}
