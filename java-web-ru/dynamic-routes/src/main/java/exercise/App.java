package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;

// BEGIN
import io.javalin.http.NotFoundResponse;
// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config ->
            config.bundledPlugins.enableDevLogging());

        // BEGIN
        app.get("/companies/{id}", ctx -> {
            String id = ctx.pathParamAsClass("id", String.class).get();

            Map<String, String> selectedCompany = COMPANIES.stream()
                    .filter(map -> map.get("id").equals(id))
                    .findAny().orElse(null);

            if (selectedCompany == null) {
                throw new NotFoundResponse("Company not found");
            }

            ctx.json(selectedCompany);
        });
        // END

        app.get("/companies", ctx -> ctx.json(COMPANIES));

        app.get("/", ctx ->
            ctx.result("open something like (you can change id): /companies/5"));

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
