package co.tevolvers.reto.stepdefinitions;

import co.tevolvers.reto.utils.Constants;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class Hook {

    @Before
    public void inicializarActor(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActor("Actor");
    }

    @Given("^the user open application$")
    public void theUserOpenApplication() {
        OnStage.theActorInTheSpotlight().attemptsTo(Open.url(Constants.URL));
    }

    @Given("^user automation service in url (.*)$")
    public void userAutomationServiceInUrl(String url) {
        OnStage.theActorInTheSpotlight().whoCan(CallAnApi.at(url));
    }
}
