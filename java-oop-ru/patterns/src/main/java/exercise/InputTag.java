package exercise;

// Этот тег определяет поле ввода, в которое пользователь может вводить данные.
public class InputTag implements TagInterface {
    private String type;
    private String value;

    public InputTag(String type, String value) {
        this.type = type;
        this.value = value;

    }

    public String render() {
        return "<input type=\"" + type + "\" value=\"" + value + "\">";
    }  // <input type="submit" value="Save">

}
