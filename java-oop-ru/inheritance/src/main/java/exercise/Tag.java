package exercise;

import java.util.stream.Collectors;
import java.util.Map;


public class Tag {
    private String tagName;
    private Map<String, String> tagAttributes;

    public Tag(String tagName, Map<String, String> tagAttributes) {
        this.tagName = tagName;
        this.tagAttributes = tagAttributes;
    }

    public String getTagName() {
        return tagName;
    }

    public String attributesOneLine() {
        return tagAttributes.entrySet().stream() //возвращаем набор записей (пар ключ-значение) из карты
                .map(object -> String.format(" %s=\"%s\"", object.getKey(), object.getValue()))
                .collect(Collectors.joining(""));
    }

    public String toString() {
        return "<" + getTagName() + attributesOneLine() + ">"; //<img class="v-10" id="wop">
    }
}
