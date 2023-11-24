package co.com.sofka.certification.tasks;

import static co.com.sofka.certification.userinterfaces.SendToUI.TV_CHOOSE_CITY;

import com.google.common.collect.ImmutableMap;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.DriverTask;
import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;

public class ScrollFromElementTask implements Task {
    private Target fromTarget;
    private Double percent;
    private String direction;
    private Double speed;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                scrollFrom(actor)
        );
    }

    public static ScrollFromElementTask scrollFromElement() {
        return new ScrollFromElementTask();
    }

    private Performable scrollFrom(Actor actor) {
        return new DriverTask(
                driver -> {
                    ((JavascriptExecutor) driver)
                            .executeScript("mobile: scrollGesture",
                                    ImmutableMap.of(
                                            "elementId", ((RemoteWebElement) fromTarget.resolveFor(actor).getElement()).getId(),
                                            "direction", direction,
                                            "percent", percent,
                                            "speed", speed
                                    )
                            );
                }
        );
    }


    public ScrollFromElementTask fromElement(Target target) {
        this.fromTarget = target;
        return this;
    }

    public ScrollFromElementTask andPercent(Double percent) {
        this.percent = percent;
        return this;
    }

    public ScrollFromElementTask inDirection(String direction) {
        this.direction = direction;
        return this;
    }

    public ScrollFromElementTask andSpeed(Double speed) {
        this.speed = speed;
        return this;
    }


}
