package co.com.sofka.certification.stepdefinitions;

import static co.com.sofka.certification.Interactions.AddItemToCartInteraction.addItemToCart;
import static co.com.sofka.certification.models.MobileAppiumDriver.enableMultiWindows;
import static co.com.sofka.certification.tasks.DoCheckoutTask.doCheckout;
import static co.com.sofka.certification.tasks.EnterAdressTask.enterAdress;
import static co.com.sofka.certification.tasks.EnterShoppingCartTask.enterShoppingCart;
import static co.com.sofka.certification.tasks.InitialStepsTask.doInitialSteps;
import static co.com.sofka.certification.tasks.LookForItemTask.lookFor;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;
import java.util.Map;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BuyStepDefinition {
    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @Before
    public void actorConfig() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{actor} enters into the shopping section using his city {string} and address {string}")
    public void juanEntersIntoTheShoppingSectionUsingHisCityAndAddress(Actor actor, String city, String address)
    {
        enableMultiWindows();
        actor.attemptsTo(
                doInitialSteps(),
                enterAdress().withCity(city).andAdress(address)
        );
    }

    @When("{actor} looks for an {string}")
    public void heLooksForAn(Actor actor, String item) {
        actor.attemptsTo(
                lookFor().item(item)
        );
    }

    @When("{actor} added it to the shopping cart")
    public void heAddedItToTheShoppingCart(Actor actor) {
        actor.attemptsTo(
                addItemToCart()
        );
    }


    @And("{actor} finishes the checkout process sending the item to his house with this data:")
    public void heFinishesTheCheckoutProcessSendingTheItemToHisHouseWithThisData(Actor actor, List<Map<String, String>> listUserData) {
        Map<String, String> userData = listUserData.get(0);
        actor.attemptsTo(
                enterShoppingCart(),
                doCheckout().with(userData)
        );
    }

    @Then("{actor} must see the pen added on checkout page")
    public void juanMustSeeThePenAddedOnCheckoutPage(Actor actor) {
        System.out.println("Hola");
    }


}
