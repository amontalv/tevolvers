package co.tevolvers.reto.tasks;

import co.tevolvers.reto.utils.UrlEnum;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class CreateToken implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        String body = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        actor.attemptsTo(Post.to(UrlEnum.URI_CREATE_TOKEN.getValue()).
                with(requestSpecification -> requestSpecification.
                        header("Content-Type","application/json").header("Accept","application/json").
                        body(body)));

        String token = SerenityRest.lastResponse().body().asString();
        actor.remember("token",token);
    }

    public static CreateToken auth() {
        return Tasks.instrumented(CreateToken.class);
    }
}
