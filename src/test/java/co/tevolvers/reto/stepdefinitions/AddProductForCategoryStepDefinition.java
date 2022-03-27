package co.tevolvers.reto.stepdefinitions;

import co.tevolvers.reto.models.AddProductForCategoryModel;
import co.tevolvers.reto.questions.ValidateProducts;
import co.tevolvers.reto.tasks.AddProductForCategory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.CoreMatchers;

import java.util.List;

public class AddProductForCategoryStepDefinition {


    @When("^add product in the cart$")
    public void addProductInTheCart(List<AddProductForCategoryModel> products) {
        OnStage.theActorInTheSpotlight().attemptsTo(AddProductForCategory.withProduct(products.get(0).getProducts()));
    }

    @Then("^view number of product in the cart (.*)$")
    public void viewNumberOfProductInTheCart(String result) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateProducts.inTheCart(),CoreMatchers.equalTo(result)));
    }
}
