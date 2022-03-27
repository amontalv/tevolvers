package co.tevolvers.reto.tasks;

import co.tevolvers.reto.models.BookingModel;
import co.tevolvers.reto.utils.UrlEnum;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.List;

public class CreateBooking implements Task {

    private List<BookingModel> datos;

    public CreateBooking(List<BookingModel> datos) {
        this.datos = datos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String body = "{\n" +
                "  \"firstname\": \"" + datos.get(0).getFirstname() + "\",\n" +
                "\"lastname\" : \"" + datos.get(0).getLastname() + "\",\n" +
                "\"totalprice\" : " + datos.get(0).getTotalprice() + ",\n" +
                "\"depositpaid\" :" + datos.get(0).isDepositpaid() + ",\n" +
                "\"bookingdates\" : {\n" +
                "\"checkin\" : \"" + datos.get(0).getCheckin() + "\",\n" +
                "\"checkout\" : \"" + datos.get(0).getCheckout() + "\"\n" +
                "},\n" +
                "\"additionalneeds\" :  \""+ datos.get(0).getAdditionalneeds() +"\"\n" + "}";

        actor.attemptsTo(Post.to(UrlEnum.URI_CREATE_BOOKING.getValue()).
                with(requestSpecification -> requestSpecification.
                        header("Content-Type","application/json").header("Accept","application/json").
                        body(body)));

        String respuesta = SerenityRest.lastResponse().body().asString();
        actor.remember("respuesta",respuesta);

    }

    public static CreateBooking withInformation(List<BookingModel> datos) {
        return Tasks.instrumented(CreateBooking.class, datos);
    }
}
