package co.com.sofka.certification.tasks;

import static co.com.sofka.certification.userinterfaces.SendToUI.TV_CHOOSE_CITY;

import com.google.common.collect.ImmutableMap;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.actions.DriverTask;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ScrollTask implements Task {
    private Target fromTarget;
    private Target toTarget;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                scrolling(actor)
        );
    }

    public static ScrollTask scroll() {
        return new ScrollTask();
    }

    private Performable scrolling(Actor actor) {
        return new DriverTask(
                webDriver -> {
                    boolean scrolling = true;
                    boolean targetNotVisible = !toTarget.isVisibleFor(actor);

                    while (targetNotVisible && scrolling)
                    {
                        scrolling = scrollTo(webDriver,actor);
                        targetNotVisible = !toTarget.isVisibleFor(actor);
                    }
                }
        );
    }
    public Boolean scrollTo(WebDriver driver, Actor actor)
    {
        return (Boolean) ((JavascriptExecutor) driver)
                .executeScript("mobile: scrollGesture",
                        ImmutableMap.of(
                                //"elementId", ((RemoteWebElement) fromTarget.resolveFor(actor).getElement()).getId(),
                                "left", 100, "top", 500, "width", 100, "height", 500,
                                "direction", "down",
                                "percent", 1.0,
                                "speed", 10000
                        )
                );
    }

    public ScrollTask fromElement(String target) {
        this.fromTarget = TV_CHOOSE_CITY.of(target);
        return this;
    }

    public ScrollTask lookingFor(String target) {
        this.toTarget = TV_CHOOSE_CITY.of(target);
        return this;
    }
}
