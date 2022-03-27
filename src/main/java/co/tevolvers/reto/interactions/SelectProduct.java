package co.tevolvers.reto.interactions;

import co.tevolvers.reto.tasks.AddToCart;
import co.tevolvers.reto.userinterface.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import java.util.ArrayList;
import java.util.List;

public class SelectProduct implements Interaction {
    private String products;

    public SelectProduct(String products) {
        this.products = products;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String[] product = products.split(",");
        for (String s : product) {
            actor.attemptsTo(Scroll.to(AddProductForCategoryUser.BTN_MENU_PHONES),
                    Click.on(AddProductForCategoryUser.BTN_MENU_PHONES));
            if (AddProductForCategoryUser.BTN_OPTION_PRODUCT.of(s).resolveFor(actor).isPresent()) {
                actor.attemptsTo(Scroll.to(AddProductForCategoryUser.BTN_OPTION_PRODUCT.of(s)),
                        Click.on(AddProductForCategoryUser.BTN_OPTION_PRODUCT.of(s))
                        , AddToCart.inOption()
                        , Click.on(AddProductForCategoryUser.BTN_HOME));
            } else {
                actor.attemptsTo(Scroll.to(AddProductForCategoryUser.BTN_MENU_LAPTOPS),
                        Click.on(AddProductForCategoryUser.BTN_MENU_LAPTOPS));
                if (AddProductForCategoryUser.BTN_OPTION_PRODUCT.of(s).resolveFor(actor).isPresent()) {
                    actor.attemptsTo(Scroll.to(AddProductForCategoryUser.BTN_OPTION_PRODUCT.of(s)),
                            Click.on(AddProductForCategoryUser.BTN_OPTION_PRODUCT.of(s))
                            , AddToCart.inOption()
                            , Click.on(AddProductForCategoryUser.BTN_HOME));
                } else {
                    actor.attemptsTo(Scroll.to(AddProductForCategoryUser.BTN_MENU_MONITORS),
                            Click.on(AddProductForCategoryUser.BTN_MENU_MONITORS));
                    if (AddProductForCategoryUser.BTN_OPTION_PRODUCT.of(s).resolveFor(actor).isPresent()) {
                        actor.attemptsTo(Scroll.to(AddProductForCategoryUser.BTN_OPTION_PRODUCT.of(s)),
                                Click.on(AddProductForCategoryUser.BTN_OPTION_PRODUCT.of(s))
                                , AddToCart.inOption()
                                , Click.on(AddProductForCategoryUser.BTN_HOME));
                    }
                }
            }
        }
    }

    public static SelectProduct withProduct(String products) {
        return Tasks.instrumented(SelectProduct.class, products);
    }

}
