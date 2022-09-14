package co.com.sofka.certification.tasks;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static co.com.sofka.certification.Interactions.HideKeyboardInteraction.hideKeyboard;
import static co.com.sofka.certification.tasks.EnterUserDataTask.enter;
import static co.com.sofka.certification.tasks.ScrollFromAreaTask.scrollFromArea;
import static co.com.sofka.certification.tasks.ScrollToCheckTotalPriceTask.scrollToCheckTotalPrice;
import static co.com.sofka.certification.tasks.ScrollToElementTask.scrollToElement;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.BT_CONTINUE_TO_INSERT_USER_DATA;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.BT_DO_CHECKOUT;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.BT_GO_TO_PAYMENT;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.BT_GO_TO_SHIPPING;
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

public class DoCheckoutToStoreTask implements Task {
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
                WaitUntil.the(BT_DO_CHECKOUT, isVisible()).forNoMoreThan(Duration.ofSeconds(20)),
                Click.on(BT_DO_CHECKOUT),
                WaitUntil.the(ET_INSERT_USER_EMAIL, isVisible()).forNoMoreThan(Duration.ofSeconds(20)),
                Enter.theValue(userData.get("eMail")).into(ET_INSERT_USER_EMAIL),
                hideKeyboard(),
                Click.on(BT_CONTINUE_TO_INSERT_USER_DATA),
                enter().theUserData(userData),
                Click.on(BT_GO_TO_SHIPPING),
                hideKeyboard(),
                scrollFromArea()
                        .withScrollArea(scrollArea)
                        .inDirection("down")
                        .andSpeed(10000.0)
                        .andPercent(1.0)
        );
    }

    public static DoCheckoutToStoreTask doCheckoutToStore() {
        return new DoCheckoutToStoreTask();
    }

    public DoCheckoutToStoreTask with(Map<String, String> data) {
        userData = data;
        return this;
    }
}
