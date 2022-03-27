package co.tevolvers.reto.questions;

import co.tevolvers.reto.interactions.WaitInteraction;
import co.tevolvers.reto.userinterface.AddProductForCategoryUser;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;

public class ValidateProducts implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        String result = "0";
        int validate = 0;
        actor.attemptsTo(Click.on(AddProductForCategoryUser.BTN_CART),
                WaitInteraction.waitClass(1000));
        if (AddProductForCategoryUser.COUNT_RESULT.resolveFor(actor).isPresent()){
            List<WebElementFacade> resultValidate = AddProductForCategoryUser.COUNT_RESULT.resolveAllFor(actor);
            validate = resultValidate.size();
            result = String.valueOf(validate);
        }
        return result;
    }

    public static ValidateProducts inTheCart() {
        return new ValidateProducts();
    }
}
