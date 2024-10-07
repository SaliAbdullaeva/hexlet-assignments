package exercise;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// BEGIN
public class Validator {

    public static void main(String[] args) {
        Address address = new Address(null, "Ufa", "Lenina", "54", null);
        List<String> result = validate(address);
        System.out.println(result);
    }

    public static List<String> validate(Object obj) {
        List<String> result = new ArrayList<>();
        Class<?> aClass = obj.getClass();
        Field[] fieldsOfAddress = aClass.getDeclaredFields();
        for (Field field : fieldsOfAddress) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                try {
                    if (Objects.equals(field.get(obj), null)) {
                        result.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException();
                }
            }
        }
        return result;
    }
}
