package exercise;

import java.lang.reflect.Field;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Validator {

    public static List<String> validate(Address address) {
        Field[] fields = address.getClass().getDeclaredFields();
        List<String> nullFields = new ArrayList<>();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(NotNull.class) && field.get(address) == null) {
                    nullFields.add(field.getName());
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        return nullFields;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Field[] fields = address.getClass().getDeclaredFields();
        Map<String, List<String>> notValidFields = new HashMap<>();

        try {
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldValue = (String) field.get(address);
                List<String> message = new ArrayList<>();

                if (field.getDeclaredAnnotations().length == 0) {
                    continue;
                }

                if (field.isAnnotationPresent(NotNull.class) && fieldValue == null) {
                    message.add("can not be null");
                    notValidFields.put(field.getName(), message);
                    continue;
                }

                if (field.isAnnotationPresent(MinLength.class)) {
                    int minLength = field.getAnnotation(MinLength.class).minLength();
                    if (fieldValue.length() < minLength) {
                        message.add(String.format("length less than %d", minLength));
                        notValidFields.put(field.getName(), message);
                    }
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException e) {
            e.printStackTrace();
        }

        return notValidFields;
    }
}
