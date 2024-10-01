package exercise;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FileKV implements KeyValueStorage {
    private String path; //например "src/test/resources/file"
    private Map<String, String> data = new HashMap<>();

    public FileKV(String path, Map<String, String> initialData) {
        this.path = path;
        data.putAll(initialData);
    }

    @Override
    public void set(String key, String value) {
        this.data.put(key, value);
    }

    @Override
    public void unset(String key) {
        this.data.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return this.data.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(data);

    }
}
