package co.com.sofka.certification.tasks;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static co.com.sofka.certification.Interactions.HideKeyboardInteraction.hideKeyboard;
import static co.com.sofka.certification.userinterfaces.CheckoutUI.BT_CONTINUE_TO_INSERT_USER_DATA;
import static co.com.sofka.certification.userinterfaces.CheckoutUI.BT_DO_CHECKOUT;
import static co.com.sofka.certification.userinterfaces.CheckoutUI.BT_GO_TO_SHIPPING;
import static co.com.sofka.certification.userinterfaces.CheckoutUI.ET_INSERT_USER_CELL_PHONE;
import static co.com.sofka.certification.userinterfaces.CheckoutUI.ET_INSERT_USER_EMAIL;
import static co.com.sofka.certification.userinterfaces.CheckoutUI.ET_INSERT_USER_FIRST_NAME;
import static co.com.sofka.certification.userinterfaces.CheckoutUI.ET_INSERT_USER_ID;
import static co.com.sofka.certification.userinterfaces.CheckoutUI.ET_INSERT_USER_LAST_NAME;
import static co.com.sofka.certification.userinterfaces.CheckoutUI.ET_SHIPPING_RECEIPT;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;
import java.util.Map;

public class DoCheckoutTask implements Task {
    private Map<String, String> userData;


    @Override
    public <T extends Actor> void performAs(T actor) {
        String evidenceData = actor.recall("itemPrice");
        Serenity.recordReportData().withTitle("item Price").andContents(evidenceData);
        String receiverName = userData.get("firstName") + " " + userData.get("lastName");

        actor.attemptsTo(
                Click.on(BT_DO_CHECKOUT),
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
                //TODO se necesita un scroll para poder ingresar el dato siguiente
                Enter.theValue(receiverName).into(ET_SHIPPING_RECEIPT),
                hideKeyboard()
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
