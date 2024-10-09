package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import lombok.Value;


@Value
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    public String serialize() {
        var mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonMappingException e) {
            throw new RuntimeException("Ошибка отображания", e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Общая ошибка обработки JSON", e);
        }
    }

    public static Car deserialize(String json) {
        var mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, Car.class);
        } catch (IOException e) {
            throw new RuntimeException( "Проблема с записью JSON-данных в поток вывода", e);
        }
    }
}
