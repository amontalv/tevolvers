package co.tevolvers.reto.tasks;

import co.tevolvers.reto.interactions.SelectProduct;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class AddProductForCategory implements Task {

    private String products;

    public AddProductForCategory(String products) {
        this.products = products;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(SelectProduct.withProduct(products));
    }

    public static AddProductForCategory withProduct(String products) {
        return Tasks.instrumented(AddProductForCategory.class,products);
    }
}
