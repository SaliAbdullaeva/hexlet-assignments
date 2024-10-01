package exercise;

import java.util.HashMap;
import java.util.Map;

public class InMemoryKV implements KeyValueStorage {
    private Map<String, String> data = new HashMap<>();

    public InMemoryKV(Map<String, String> initialData) {
        data.putAll(initialData);

    }

//добавляет в словарь новое значение по указанному ключу (или меняет значение, если ключ уже существует).
    @Override
    public void set(String key, String value) {
        data.put(key, value);
    }

//удаляет из словаря значение по переданному ключу
    @Override
    public void unset(String key) {
        data.remove(key);
    }

//возвращает значение по указанному ключу. Если такого ключа в словаре нет, возвращает значение по умолчанию.
    @Override
    public String get(String key, String defaultValue) {
        return data.getOrDefault(key, defaultValue);
    }

//возвращает базу данных в виде словаря Map.
    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(data);

    }
}
