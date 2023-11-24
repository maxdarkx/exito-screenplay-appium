package co.com.sofka.certification.tasks;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static co.com.sofka.certification.Interactions.HideKeyboardInteraction.hideKeyboard;
import static co.com.sofka.certification.tasks.EnterUserDataTask.enter;
import static co.com.sofka.certification.tasks.PressTheKeyTask.press;
import static co.com.sofka.certification.tasks.ScrollToElementTask.scrollToElement;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.BT_CONTINUE_TO_INSERT_USER_DATA;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.BT_CONTINUE_TO_SHIPPING;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.BT_GO_TO_PAYMENT;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.BT_PROCESS_PAYMENT;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.CB_DATA_TREATMENT;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.CB_TERMS_AND_CONDITIONS;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.ET_INSERT_USER_EMAIL;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.ET_SHIPPING_RECEIPT;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import io.appium.java_client.android.nativekey.AndroidKey;

public class DoCheckoutTask implements Task {
    private Map<String, String> userData;


    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, Integer> scrollArea = new HashMap<>();
        scrollArea.put("left", 500);
        scrollArea.put("top", 200);
        scrollArea.put("width", 100);
        scrollArea.put("height", 1600);

        String evidenceData = actor.recall("itemPrice");
        Serenity.recordReportData().withTitle("item Price").andContents(evidenceData);
        String receiverName = userData.get("firstName").concat(" " + userData.get("lastName"));

        actor.attemptsTo(
                WaitUntil.the(ET_INSERT_USER_EMAIL, isVisible()).forNoMoreThan(Duration.ofSeconds(40)),
                Click.on(ET_INSERT_USER_EMAIL),
                Enter.theValue(userData.get("eMail")).into(ET_INSERT_USER_EMAIL),
                press().theKey(AndroidKey.ENTER),
                Click.on(BT_CONTINUE_TO_INSERT_USER_DATA)
                );

        actor.attemptsTo(
                scrollToElement()
                        .lookingFor(BT_PROCESS_PAYMENT)
                        .withScrollArea(scrollArea)
                        .inDirection("down")
                        .andSpeed(10000.0)
                        .andPercent(0.5),
                Click.on(BT_PROCESS_PAYMENT)
        );

        actor.attemptsTo(
                enter().theUserData(userData),
                scrollToElement()
                        .lookingFor(BT_CONTINUE_TO_SHIPPING)
                        .withScrollArea(scrollArea)
                        .inDirection("up")
                        .andSpeed(10000.0)
                        .andPercent(0.5),
                Click.on(BT_CONTINUE_TO_SHIPPING)
        );

        actor.attemptsTo(
                Enter.theValue(receiverName).into(ET_SHIPPING_RECEIPT),
                Click.on(BT_GO_TO_PAYMENT)
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
