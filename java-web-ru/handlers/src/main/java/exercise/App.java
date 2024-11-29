package exercise;

import io.javalin.Javalin;
import java.util.List;

public final class App {

    public static Javalin getApp() {
        Javalin app = Javalin.create(); // Создаем экземпляр Javalin

        // Обработчик для GET /phones
        app.get("/phones", ctx -> {
            List<String> phones = Data.getPhones(); // Получаем список телефонов
            ctx.json(phones); // Возвращаем список в формате JSON
        });

        // Обработчик для GET /domains
        app.get("/domains", ctx -> {
            List<String> domains = Data.getDomains(); // Получаем список доменов
            ctx.json(domains); // Возвращаем список в формате JSON
        });

        return app; // Возвращаем экземпляр приложения
    }

    public static void main(String[] args) {
        Javalin app = getApp(); // Получаем экземпляр приложения
        app.start(7000); // Запускаем сервер на порту 7000
    }
}