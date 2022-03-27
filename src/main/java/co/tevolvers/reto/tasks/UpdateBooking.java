package co.tevolvers.reto.tasks;

import co.tevolvers.reto.models.BookingModel;
import co.tevolvers.reto.utils.JsonParserResponse;
import co.tevolvers.reto.utils.UrlEnum;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;

import java.util.List;

public class UpdateBooking implements Task {
    private String id;
    private List<BookingModel> datos;

    public UpdateBooking(String id) {
        this.id = id;
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
        actor.attemptsTo(CreateToken.auth());
        String valorRespuesta = actor.recall("token");
        String token = JsonParserResponse.valueResponse("token",valorRespuesta);
        System.out.println(token);
        actor.attemptsTo(Put.to(UrlEnum.URI_UPDATE_BOOKING.getValue() + id).
                with(requestSpecification-> requestSpecification.
                        header("Content-Type","application/json","Accept","application/json").
                        header("Cookie","token=" + token)
                      .body(body)));
        SerenityRest.lastResponse().body().prettyPrint();
        String respuesta = SerenityRest.lastResponse().body().asString();
        actor.remember("respuesta",respuesta);
    }

    public static UpdateBooking with(String id) {
        return Tasks.instrumented(UpdateBooking.class,id);
    }

    public UpdateBooking withInfo(List<BookingModel> datos){
        this.datos =datos;
        return this;
    }
}
