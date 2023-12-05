package se.eg.aoc.day5;

import org.checkerframework.checker.units.qual.A;
import se.eg.aoc.util.FileReader;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Day5 {

    List<Long> seeds = new ArrayList<>();
    Map<MapType, List<ConversionMapper>> maps = new EnumMap<>(MapType.class);

    static Day5 fromFile(String filename){
        Day5 day5 = new Day5();
        var lines = FileReader.readInputFile(filename);
        parseSeeds(lines.get(0), day5);
        MapType currentMapType = null;
        for (int lineIndex = 1; lineIndex < lines.size(); lineIndex++){
            String line = lines.get(lineIndex);
            if (line.isEmpty()){
                continue;
            }
            else if(line.matches("\\D+")){
                currentMapType = MapType.fromLabel(line.strip().split(" ")[0]);
            }
            else {
                List<ConversionMapper> conversionMappers = day5.maps.getOrDefault(currentMapType, new ArrayList<>());
                String[] split = line.split(" ");
                conversionMappers.add(new ConversionMapper(Long.parseLong(split[0].strip()),Long.parseLong(split[1].strip()), Long.parseLong(split[2].strip())));
                day5.maps.put(currentMapType, conversionMappers);
            }
        }
        return day5;
    }

    static void parseSeeds(String line, Day5 instance){
        String[] split = line.split(":")[1].strip().split(" ");
        for (String seed : split){
            instance.seeds.add(Long.parseLong(seed.strip()));
        }
    }

    long seedToLocation(long seed){
        long mappedToNext = seed;
        for (MapType mapType : MapType.values()) {
            mappedToNext = useMapper(this.maps.get(mapType), mappedToNext);
        }
        return mappedToNext;
    }

    long useMapper(List<ConversionMapper> conversionMappers, long sourceNumber){
        for (ConversionMapper conversionMapper : conversionMappers){
            long mappedValue = conversionMapper.mapFromSource(sourceNumber);
            if (mappedValue != -1){
                return mappedValue;
            }
        }
        return sourceNumber;
    }

    long findLowestLocationNumberFromSeeds(){
        return seeds.stream().map(this::seedToLocation).mapToLong(Long::longValue).min().getAsLong();
    }
}
