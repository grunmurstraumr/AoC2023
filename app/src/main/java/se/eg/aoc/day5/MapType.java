package se.eg.aoc.day5;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;

public enum MapType {
    SEED_TO_SOIL, SOIL_TO_FERTILIZER, FERTILIZER_TO_WATER,
    WATER_TO_LIGHT, LIGHT_TO_TEMPERATURE, TEMPERATURE_TO_HUMIDITY, HUMIDITY_TO_LOCATION;

    private static final Map<String, MapType> labelMapping;

    static {
        labelMapping = new HashMap<>();
        for (MapType mapType : values()){
            labelMapping.put(mapType.getLabel(), mapType);
        }
    }

    public String getLabel(){
        return this.name().replace('_', '-').toLowerCase();
    }

    public static MapType fromLabel(String label){
        return labelMapping.get(label);
    }
}
