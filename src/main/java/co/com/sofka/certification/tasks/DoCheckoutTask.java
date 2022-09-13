package co.com.sofka.certification.tasks;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static co.com.sofka.certification.Interactions.HideKeyboardInteraction.hideKeyboard;
import static co.com.sofka.certification.tasks.ScrollToElementTask.scrollToElement;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.BT_CONTINUE_TO_INSERT_USER_DATA;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.BT_DO_CHECKOUT;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.BT_GO_TO_PAYMENT;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.BT_GO_TO_SHIPPING;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.ET_INSERT_USER_CELL_PHONE;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.ET_INSERT_USER_EMAIL;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.ET_INSERT_USER_FIRST_NAME;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.ET_INSERT_USER_ID;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.ET_INSERT_USER_LAST_NAME;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.ET_SHIPPING_RECEIPT;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.GV_TOTAL;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.TV_TOTAL_PRICE;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DoCheckoutTask implements Task {
    private Map<String, String> userData;


    @Override
    public <T extends Actor> void performAs(T actor) {
        String evidenceData = actor.recall("itemPrice");
        Serenity.recordReportData().withTitle("item Price").andContents(evidenceData);
        String receiverName = userData.get("firstName") + " " + userData.get("lastName");
        Map<String, Integer> scrollArea = new HashMap<>();
        scrollArea.put("left", 500);
        scrollArea.put("top", 200);
        scrollArea.put("width", 100);
        scrollArea.put("height", 1600);

        actor.attemptsTo(
                Click.on(BT_DO_CHECKOUT),
                WaitUntil.the(ET_INSERT_USER_EMAIL, isVisible()).forNoMoreThan(Duration.ofSeconds(20)),
                Enter.theValue(userData.get("eMail")).into(ET_INSERT_USER_EMAIL),
                hideKeyboard(),
                Click.on(BT_CONTINUE_TO_INSERT_USER_DATA),
                WaitUntil.the(ET_INSERT_USER_LAST_NAME, isVisible()).forNoMoreThan(Duration.ofSeconds(20)),
                Enter.theValue(userData.get("firstName")).into(ET_INSERT_USER_FIRST_NAME),
                hideKeyboard(),
                Enter.theValue(userData.get("lastName")).into(ET_INSERT_USER_LAST_NAME),
                Enter.theValue(userData.get("cellPhone")).into(ET_INSERT_USER_CELL_PHONE),
                Enter.theValue(userData.get("id")).into(ET_INSERT_USER_ID),
                Click.on(BT_GO_TO_SHIPPING),
                scrollToElement()
                        .lookingFor(ET_SHIPPING_RECEIPT)
                        .withScrollArea(scrollArea)
                        .inDirection("down")
                        .andSpeed(10000.0)
                        .andPercent(0.5),
                Enter.theValue(receiverName).into(ET_SHIPPING_RECEIPT),
                hideKeyboard(),

                //TODO refinar el scroll final y comparar subtotal y envio
                //partir en subtareas para facilitar comprension
                Click.on(BT_GO_TO_PAYMENT),
                scrollToElement()
                        .lookingFor(TV_TOTAL_PRICE.inside(GV_TOTAL))
                        .withScrollArea(scrollArea)
                        .inDirection("down")
                        .andSpeed(10000.0)
                        .andPercent(0.5),
                Click.on(TV_TOTAL_PRICE.inside(GV_TOTAL))

                );
    }

    public static DoCheckoutTask doCheckout() {
        return new DoCheckoutTask();
    }

    public DoCheckoutTask with(Map<String, String> data) {
        userData = data;
        return this;
    }
}
