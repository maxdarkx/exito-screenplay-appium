package co.com.sofka.certification.tasks;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static co.com.sofka.certification.tasks.ScrollFromAreaTask.scrollFromArea;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.ET_CLIENT_EMAIL;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;
import java.util.Map;

public class ScrollToCheckTotalPriceSendingToStoreTask implements Task {
    private Map<String, Integer> area;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                scrollFromArea()
                        .withScrollArea(area)
                        .inDirection("down")
                        .andSpeed(10000.0)
                        .andPercent(1.0),
                scrollFromArea()
                        .withScrollArea(area)
                        .inDirection("down")
                        .andSpeed(10000.0)
                        .andPercent(0.75)
        );
    }

    public static ScrollToCheckTotalPriceSendingToStoreTask scrollToCheckTotalPriceSendingToStore()
    {
        return new ScrollToCheckTotalPriceSendingToStoreTask();
    }

    public ScrollToCheckTotalPriceSendingToStoreTask withScrollArea(Map<String, Integer> scrollArea)
    {
        area = scrollArea;
        return this;
    }
}
