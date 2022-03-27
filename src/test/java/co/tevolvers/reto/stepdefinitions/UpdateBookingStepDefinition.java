package co.tevolvers.reto.stepdefinitions;

import co.tevolvers.reto.models.BookingModel;
import co.tevolvers.reto.tasks.UpdateBooking;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;

public class UpdateBookingStepDefinition {

    @When("^User want update booking to service with (.*)$")
    public void userWantUpdateBookingToServiceWith(String id, List<BookingModel> datos) {
        OnStage.theActorInTheSpotlight().attemptsTo(UpdateBooking.with(id).withInfo(datos));
    }
}
