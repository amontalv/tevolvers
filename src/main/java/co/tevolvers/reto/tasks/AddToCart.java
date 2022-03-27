package co.tevolvers.reto.tasks;

import co.tevolvers.reto.interactions.WaitInteraction;
import co.tevolvers.reto.userinterface.AddProductForCategoryUser;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class AddToCart implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(AddProductForCategoryUser.BTN_ADD_TO_CART, WebElementStateMatchers.isPresent()),
                Click.on(AddProductForCategoryUser.BTN_ADD_TO_CART),
                WaitInteraction.waitClass(1000));
        BrowseTheWeb.as(actor).getAlert().accept();
    }

    public static AddToCart     inOption(){
        return Tasks.instrumented(AddToCart.class);
    }
}
