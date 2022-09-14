package co.com.sofka.certification.tasks;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static co.com.sofka.certification.userinterfaces.SendToUI.LIST_LOCAL_STORES_AVAILABLE;
import static co.com.sofka.certification.userinterfaces.SendToUI.SP_CHOOSE_LOCAL_STORE;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

public class SelectTheFirstStoreAvailableTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElementFacade firstStore = LIST_LOCAL_STORES_AVAILABLE.resolveAllFor(actor).get(0);

        actor.attemptsTo(
                WaitUntil.the(LIST_LOCAL_STORES_AVAILABLE, isVisible()).forNoMoreThan(Duration.ofSeconds(10)),
                Click.on(firstStore)
        );
    }

    public static SelectTheFirstStoreAvailableTask selectTheFirstStoreAvailable()
    {
        return new SelectTheFirstStoreAvailableTask();
    }
}
