package co.com.sofka.certification.tasks;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static co.com.sofka.certification.tasks.ScrollToElementTask.scrollToElement;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.BT_CONTINUE_TO_SHIPPING;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.BT_PROCESS_PAYMENT;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.CB_DATA_TREATMENT;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.CB_TERMS_AND_CONDITIONS;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.ET_INSERT_USER_CELL_PHONE;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.ET_INSERT_USER_FIRST_NAME;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.ET_INSERT_USER_ID;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.ET_INSERT_USER_LAST_NAME;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.CheckCheckbox;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SetCheckbox;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class EnterUserDataTask implements Task {
    private Map<String, String> userData;

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, Integer> scrollArea = new HashMap<>();
        scrollArea.put("left", 500);
        scrollArea.put("top", 200);
        scrollArea.put("width", 100);
        scrollArea.put("height", 1600);

        actor.attemptsTo(
                WaitUntil.the(ET_INSERT_USER_FIRST_NAME, isVisible()).forNoMoreThan(Duration.ofSeconds(20)),
                Enter.theValue(userData.get("firstName")).into(ET_INSERT_USER_FIRST_NAME),
                Enter.theValue(userData.get("lastName")).into(ET_INSERT_USER_LAST_NAME),
                Enter.theValue(userData.get("cellPhone")).into(ET_INSERT_USER_CELL_PHONE),
                Enter.theValue(userData.get("id")).into(ET_INSERT_USER_ID),

                Check.whether(CB_TERMS_AND_CONDITIONS.isVisibleFor(actor))
                        .otherwise(
                                scrollToElement()
                                        .lookingFor(CB_TERMS_AND_CONDITIONS)
                                        .withScrollArea(scrollArea)
                                        .inDirection("down")
                                        .andSpeed(10000.0)
                                        .andPercent(0.5)
                        ).then(SetCheckbox.of(CB_TERMS_AND_CONDITIONS).toTrue()),
                SetCheckbox.of(CB_DATA_TREATMENT).toTrue(),

                Check.whether(BT_CONTINUE_TO_SHIPPING.isVisibleFor(actor))
                        .otherwise(
                                scrollToElement()
                                        .lookingFor(BT_CONTINUE_TO_SHIPPING)
                                        .withScrollArea(scrollArea)
                                        .inDirection("down")
                                        .andSpeed(10000.0)
                                        .andPercent(0.5)
                        ),
                Click.on(BT_CONTINUE_TO_SHIPPING)
        );
    }

    public static EnterUserDataTask enter() {
        return new EnterUserDataTask();
    }

    public EnterUserDataTask theUserData(Map<String, String> data) {
        userData = data;
        return this;
    }
}
