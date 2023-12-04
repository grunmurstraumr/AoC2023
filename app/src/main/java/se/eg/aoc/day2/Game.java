package se.eg.aoc.day2;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class Game {
    int id;
    List<CubeSet> cubeSets = new ArrayList<>();

    public static Game fromLine(String line){
        var instance = new Game();
        var split = line.split(":");
        instance.id = Integer.parseInt(split[0].replace("Game", "").trim());
        var cubesets = split[1].split(";");
        for (String cubesetString : cubesets ) {
            instance.cubeSets.add(CubeSet.fromString(cubesetString));
        }
        return instance;
    }

    public Map<CubeColor, Integer> getTotals(){
        var totalsMap = Stream.of(CubeColor.values()).collect(Collectors.toMap(Function.identity(), e -> 0));
        for (CubeSet cubeSet : cubeSets) {
            for (CubeColor color : CubeColor.values()) {
                totalsMap.put(color, totalsMap.get(color) + cubeSet.getColourCount(color));
            }
        }
        return totalsMap;
    }

    public Map<CubeColor, Integer> getMaxes(){
        var maxMap = Stream.of(CubeColor.values()).collect(Collectors.toMap(Function.identity(), e -> 0));
        for (CubeSet cubeSet : cubeSets) {
            for (CubeColor color : CubeColor.values()) {
                if (cubeSet.getColourCount(color) > maxMap.get(color)) {
                    maxMap.put(color, cubeSet.getColourCount(color));
                }
            }
        }
        return maxMap;
    }

    public boolean isPossible(CubeSet cubeSet) {
        var maxes = getMaxes();
        for (CubeColor color : CubeColor.values()) {
            if (maxes.get(color) > cubeSet.getColourCount(color) ){
                return false;
            }
        }
        return true;
    }

    int calculateMinumCubePower(){
        return getMaxes().values().stream().mapToInt(Integer::intValue).reduce(1, (a,b) -> a * b);
    }
}
