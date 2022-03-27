package co.tevolvers.reto.stepdefinitions;

import co.tevolvers.reto.models.BookingModel;
import co.tevolvers.reto.tasks.CreateBooking;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;

import java.util.List;

public class CreateBookingStepDefinition {

    @When("^User want create booking to service$")
    public void userWantCreateBookingToService(List<BookingModel> datos) {
        OnStage.theActorInTheSpotlight().attemptsTo(CreateBooking.withInformation(datos));
    }

    @Then("^User validate the status code (.*)$")
    public void userValidateTheStatusCode(int status) {
        OnStage.theActorInTheSpotlight().should(ResponseConsequence.seeThatResponse(
                validatableResponse -> validatableResponse.statusCode(status)));
    }


}
