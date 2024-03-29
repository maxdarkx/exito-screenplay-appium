package co.com.sofka.certification.tasks;

import static co.com.sofka.certification.userinterfaces.InitialUI.BT_ALLOW_DETECT_LOCATION_WHILE_USING_APP;
import static co.com.sofka.certification.userinterfaces.InitialUI.BT_DISCARD_ADVERTISEMENT;
import static co.com.sofka.certification.userinterfaces.InitialUI.BT_SALES_MENU;
import static co.com.sofka.certification.userinterfaces.InitialUI.BT_START_SESSION_LATER;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;

public class InitialStepsTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Check.whether(BT_DISCARD_ADVERTISEMENT.isVisibleFor(actor))
                        .andIfSo(Click.on(BT_DISCARD_ADVERTISEMENT)),
                Click.on(BT_START_SESSION_LATER),
                Click.on(BT_ALLOW_DETECT_LOCATION_WHILE_USING_APP),
                Click.on(BT_SALES_MENU)
        );
    }

    public static InitialStepsTask doInitialSteps() {
        return new InitialStepsTask();
    }
}
