package co.com.sofka.certification.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class BuyStepDefinition {
    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @Before
    public void actorConfig() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("Juan makes log in into exito app")
    public void juanMakesLogInIntoExitoApp() {

    }
    @When("he looks for a classic pen")
    public void heLooksForAClassicPen() {

    }
    @When("he added it to the shopping cart")
    public void heAddedItToTheShoppingCart() {

    }
    @When("He finishes the chechout process sending the item to his house")
    public void heFinishesTheChechoutProcessSendingTheItemToHisHouse() {

    }
    @Then("Juan must see the pen added on che checkout page")
    public void juanMustSeeThePenAddedOnCheCheckoutPage() {

    }
}
