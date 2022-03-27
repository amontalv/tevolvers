package co.tevolvers.reto.tasks;

import co.tevolvers.reto.models.BookingModel;
import co.tevolvers.reto.utils.JsonParserResponse;
import co.tevolvers.reto.utils.UrlEnum;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.List;

public class GetBooking implements Task {
    List<BookingModel> datos;

    public GetBooking(List<BookingModel> datos) {
        this.datos = datos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String respuesta ="";
        String id = "";
        actor.attemptsTo(CreateBooking.withInformation(datos));
        respuesta = actor.recall("respuesta");
        id = JsonParserResponse.valueResponse("bookingid",respuesta);
        actor.attemptsTo(Get.resource(UrlEnum.URI_GET_BOOKING.getValue() + id)
                .with(requestSpecification -> requestSpecification.header("Accept","application/json")));
        SerenityRest.lastResponse().body().prettyPrint();

    }

    public static GetBooking withData(List<BookingModel> datos) {
        return Tasks.instrumented(GetBooking.class,datos);
    }
}
