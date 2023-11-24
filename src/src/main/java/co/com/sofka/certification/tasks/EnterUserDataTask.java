package co.com.sofka.certification.tasks;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.CB_DATA_TREATMENT;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.CB_TERMS_AND_CONDITIONS;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.ET_INSERT_USER_CELL_PHONE;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.ET_INSERT_USER_FIRST_NAME;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.ET_INSERT_USER_ID;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.ET_INSERT_USER_LAST_NAME;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;
import java.util.Map;

public class EnterUserDataTask implements Task {
    private Map<String, String> userData;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ET_INSERT_USER_FIRST_NAME, isVisible()).forNoMoreThan(Duration.ofSeconds(20)),
                Click.on(CB_TERMS_AND_CONDITIONS),
                Click.on(CB_DATA_TREATMENT),
                Enter.theValue(userData.get("firstName")).into(ET_INSERT_USER_FIRST_NAME),
                Enter.theValue(userData.get("lastName")).into(ET_INSERT_USER_LAST_NAME),
                Enter.theValue(userData.get("cellPhone")).into(ET_INSERT_USER_CELL_PHONE),
                Enter.theValue(userData.get("id")).into(ET_INSERT_USER_ID)

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
