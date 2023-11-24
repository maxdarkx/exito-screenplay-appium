package co.com.sofka.certification.stepdefinitions;

import static co.com.sofka.certification.Interactions.AddItemToCartInteraction.addItemToCart;
import static co.com.sofka.certification.models.MobileAppiumDriver.enableMultiWindows;
import static co.com.sofka.certification.tasks.DoCheckoutTask.doCheckout;
import static co.com.sofka.certification.tasks.EnterAdressTask.enterAdress;
import static co.com.sofka.certification.Interactions.EnterShoppingCartInteraction.enterShoppingCart;
import static co.com.sofka.certification.tasks.InitialStepsTask.doInitialSteps;
import static co.com.sofka.certification.tasks.LookForItemTask.lookFor;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.GV_TOTAL;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.TV_SAVINGS;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.TV_SUBTOTAL;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.TV_TOTAL_PRICE;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BuyStepDefinition {
    private Logger LOGGER = LoggerFactory.getLogger(BuyStepDefinition.class);


    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @Before
    public void actorConfig() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{actor} enters into the shopping section using his location department as {string} and his city as {string} and address {string}")
    public void juanEntersIntoTheShoppingSectionUsingHisCityAndAddress(Actor actor, String dpto, String city, String address)
    {
        //enableMultiWindows();
        actor.attemptsTo(
                doInitialSteps(),
                enterAdress()
                        .inDepartment(dpto)
                        .withCity(city)
                        .andAdress(address)
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

    @Then("{actor} must see the item added on checkout page")
    public void juanMustSeeTheItemAddedOnCheckoutPage(Actor actor)
    {
        String subTotal = TV_SUBTOTAL.inside(GV_TOTAL).resolveFor(actor).getText()
                .replace(",", "")
                .replace(".", "")
                .replace(" ", "")
                .replace("$", "");

        String listPrice =((String) actor.recall("itemPrice"))
                .replace(",", "")
                .replace(".", "")
                .replace(" ", "")
                .replace("$", "");
        Double subTotalNumber = Double.parseDouble(subTotal);
        Double listPriceNumber = Double.parseDouble(listPrice);
        LOGGER.info("Subtotal: "+subTotalNumber+" , listPrice: "+listPriceNumber);

        actor.attemptsTo(
                Ensure.that(TV_TOTAL_PRICE.inside(GV_TOTAL)).isDisplayed(),
                Ensure.that(subTotalNumber).isLessThanOrEqualTo(listPriceNumber)
        );
    }
}
