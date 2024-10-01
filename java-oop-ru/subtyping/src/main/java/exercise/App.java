package exercise;

import java.util.Map;
import java.util.Set;

public final class App {

    public static void swapKeyValue(KeyValueStorage db) {
        Map<String, String> originalMap = db.toMap();;
        Set<Map.Entry<String, String>> mapEntries = originalMap.entrySet();

        mapEntries.forEach(entry -> db.unset(entry.getKey()));
        mapEntries.forEach(entry -> db.set(entry.getValue(), entry.getKey()));
    }
}
