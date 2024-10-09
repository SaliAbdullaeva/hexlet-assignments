package exercise.demo;

import lombok.Builder;
import lombok.NonNull;

@Builder
public class Item {
    @NonNull //означает, что при создании объекта класса Item значение поля id должно быть установлено
    private Integer id;
    private String name;
    private Double price;
}
