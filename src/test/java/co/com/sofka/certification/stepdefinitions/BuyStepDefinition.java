package co.com.sofka.certification.stepdefinitions;

import static co.com.sofka.certification.Interactions.AddItemToCartInteraction.addItemToCart;
import static co.com.sofka.certification.models.MobileAppiumDriver.enableMultiWindows;
import static co.com.sofka.certification.tasks.EnterAdressTask.enterAdress;
import static co.com.sofka.certification.tasks.InitialStepsTask.doInitialSteps;
import static co.com.sofka.certification.tasks.LookForItemTask.lookFor;
import static co.com.sofka.certification.userinterfaces.InitialUI.BT_ALLOW_DETECT_LOCATION_WHILE_USING_APP;
import static co.com.sofka.certification.userinterfaces.InitialUI.BT_CLOSE_IMAGE_PROPAGANDA;
import static co.com.sofka.certification.userinterfaces.InitialUI.BT_SALES_MENU;
import static co.com.sofka.certification.userinterfaces.InitialUI.BT_SKIP_TUTORIAL;
import static co.com.sofka.certification.userinterfaces.InitialUI.BT_START_SESSION_LATER;
import static co.com.sofka.certification.userinterfaces.MarketplaceUI.BT_ADD_ITEM_TO_CART;
import static co.com.sofka.certification.userinterfaces.MarketplaceUI.VG_ITEM;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
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
    public void heFinishesTheCheckoutProcessSendingTheItemToHisHouseWithThisData(Actor actor, List<Map<String, String>> userData) {
        //TODO agregar los datos a los textview y finalizar la compra
    }

    @Then("{actor} must see the pen added on checkout page")
    public void juanMustSeeThePenAddedOnCheckoutPage(Actor actor) {
    }


}
