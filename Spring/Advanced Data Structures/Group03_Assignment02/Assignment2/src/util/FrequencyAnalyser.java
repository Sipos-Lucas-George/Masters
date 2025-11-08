package util;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class FrequencyAnalyser {
    // Analyses the byte array and returns a sorted frequency map (sorted by frequency ascending)
    public static Map<Byte, Integer> getFrequencies(byte[] data) {
        Map<Byte, Integer> unsorted = new HashMap<>();
        for (byte b : data) {
            unsorted.put(b, unsorted.getOrDefault(b, 0) + 1);
        }
        return unsorted.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                    Map.Entry::getKey, 
                    Map.Entry::getValue, 
                    (e1, e2) -> e1, 
                    LinkedHashMap::new));
    }
}