package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

class App {
    // сохраняет представление объекта Car в файл
    public static void save(Path path, Car car) {
        try {
            //сериализуем объект Car в строку JSON,
            String carToJson = car.serialize();
            //записываем строку JSON в файл по переданному пути
            Files.writeString(path, carToJson);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка сохранения в файл", e);
        }
    }
    // извлекает объект Car из файла
    public static Car extract(Path path) {
        try {
            // читаем строку JSON из файла и инициализируем переменную
            String json = Files.readString(path);
            // десериализуем строку JSON в объект Car
            return Car.deserialize(json);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения из файла", e);
        }
    }
}
