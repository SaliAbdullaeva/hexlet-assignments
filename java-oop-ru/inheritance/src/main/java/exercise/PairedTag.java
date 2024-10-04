package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class PairedTag extends Tag {
    private String tagBody;
    private List<Tag> childrenTags;

    public PairedTag(String tagName, Map<String, String> tagAttributes,
                     String tagBody, List<Tag> childrenTags) {
        super(tagName, tagAttributes);
        this.tagBody = tagBody;
        this.childrenTags = childrenTags;
    }

    public String childrenTagsOneLine() {
        return childrenTags.stream() //возвращаем набор записей (пар ключ-значение) из карты
                .map(object -> object.toString())
                .collect(Collectors.joining(""));
    }

    @Override
    public String toString() {
        return String.format("%s%s</%s>",
                super.toString(),
                tagBody + childrenTagsOneLine(),
                super.getTagName()
        );
    }
}
//// <div class="y-5"><br id="s"><hr class="a-5"></div>
