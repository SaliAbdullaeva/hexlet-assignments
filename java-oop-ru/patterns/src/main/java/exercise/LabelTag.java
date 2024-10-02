package exercise;

// умеет оборачивать другие теги
public class LabelTag implements TagInterface {
    private String text;
    private TagInterface childTag;

    public LabelTag(String text, TagInterface childTag) {
        this.text = text;
        this.childTag = childTag;
    }

    public String render() {
        return "<label>" + text + childTag.render() + "</label>";
    }

}
