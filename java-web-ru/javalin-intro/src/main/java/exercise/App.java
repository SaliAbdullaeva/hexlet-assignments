package exercise;

import io.javalin.Javalin;


public final class App {

    public static Javalin getApp() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        app.get("/welcome", ctx -> ctx.result("Welcome to Hexlet!"));
        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        // И стартуем его на порту 7070
        app.start(7070);
    }
}
