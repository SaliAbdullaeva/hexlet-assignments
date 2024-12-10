package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.model.User;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void index(Context ctx) {
        var user = ctx.sessionAttribute("currentUser");
        var page = new MainPage(user);
        ctx.render("index.jte", model("page", page));
    }

    public static void build(Context ctx) {
        var page = new LoginPage(null, null);
        ctx.render("build.jte", model("page", page));
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var password = ctx.formParam("password");

        var user = UsersRepository.findByName(name);
        if (user == null || !user.getPassword().equals(encrypt(password))) {
            var page = new LoginPage(name, "Wrong username or password");
            ctx.render("build.jte", model("page", page));
            return;
        }

        ctx.sessionAttribute("currentUser", name);
        ctx.redirect("/");
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect("/");
    }
    // END
}
