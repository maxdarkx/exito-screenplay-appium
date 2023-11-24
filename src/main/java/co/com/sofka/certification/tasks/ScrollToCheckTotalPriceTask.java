package co.com.sofka.certification.tasks;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static co.com.sofka.certification.tasks.ScrollFromAreaTask.scrollFromArea;
import static co.com.sofka.certification.userinterfaces.CheckOutUI.ET_CLIENT_EMAIL;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;
import java.util.Map;

public class ScrollToCheckTotalPriceTask implements Task {
    private Map<String, Integer> area;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ET_CLIENT_EMAIL, isVisible()).forNoMoreThan(Duration.ofSeconds(30)),
                scrollFromArea()
                        .withScrollArea(area)
                        .inDirection("down")
                        .andSpeed(10000.0)
                        .andPercent(1.0),
                scrollFromArea()
                        .withScrollArea(area)
                        .inDirection("down")
                        .andSpeed(10000.0)
                        .andPercent(1.0)
        );
    }

    public static ScrollToCheckTotalPriceTask scrollToCheckTotalPrice()
    {
        return new ScrollToCheckTotalPriceTask();
    }

    public ScrollToCheckTotalPriceTask withScrollArea(Map<String, Integer> scrollArea)
    {
        area = scrollArea;
        return this;
    }
}
