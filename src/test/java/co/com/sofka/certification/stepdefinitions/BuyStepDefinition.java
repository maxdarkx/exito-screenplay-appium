package co.com.sofka.certification.stepdefinitions;

import static co.com.sofka.certification.models.MobileAppiumDriver.enableMultiWindows;
import static co.com.sofka.certification.tasks.EnterAdressTask.enterAdress;
import static co.com.sofka.certification.tasks.InitialStepsTask.doInitialSteps;
import static co.com.sofka.certification.tasks.LookForItemTask.lookFor;
import static co.com.sofka.certification.userinterfaces.InitialUI.BT_ALLOW_DETECT_LOCATION_WHILE_USING_APP;
import static co.com.sofka.certification.userinterfaces.InitialUI.BT_CLOSE_IMAGE_PROPAGANDA;
import static co.com.sofka.certification.userinterfaces.InitialUI.BT_SALES_MENU;
import static co.com.sofka.certification.userinterfaces.InitialUI.BT_SKIP_TUTORIAL;
import static co.com.sofka.certification.userinterfaces.InitialUI.BT_START_SESSION_LATER;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
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

    @Given("{actor} enters into the shopping section")
    public void juanEntersIntoTheShoppingSection(Actor actor) {
        enableMultiWindows();
        actor.attemptsTo(
                doInitialSteps(),
                enterAdress().withCity("MEDELLIN").andAdress("Calle 111 63 B 45")
        );
    }

    @When("{actor} looks for a classic pen")
    public void heLooksForAClassicPen(Actor actor) {
        actor.attemptsTo(
            lookFor().item("Lapicero Parker")
        );
    }

    @When("{actor} added it to the shopping cart")
    public void heAddedItToTheShoppingCart(Actor actor) {
        System.out.println();
    }

    @When("{actor} finishes the checkout process sending the item to his house")
    public void heFinishesTheCheckoutProcessSendingTheItemToHisHouse(Actor actor) {

    }

    @Then("{actor} must see the pen added on che checkout page")
    public void juanMustSeeThePenAddedOnCheCheckoutPage(Actor actor) {

    }
}
