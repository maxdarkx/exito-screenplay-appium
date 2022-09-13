package co.com.sofka.certification.tasks;

import com.google.common.collect.ImmutableMap;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.DriverTask;

import org.openqa.selenium.JavascriptExecutor;

import java.util.Map;

public class ScrollFromAreaTask implements Task {
    private Map<String, Integer> scrollArea;
    private Float percent;
    private String direction;
    private Float speed;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                scrollToArea()
        );
    }

    public static ScrollFromAreaTask scrollFromArea() {
        return new ScrollFromAreaTask();
    }


    private Performable scrollToArea() {
        return new DriverTask(
                driver -> {
                    ((JavascriptExecutor) driver)
                            .executeScript("mobile: scrollGesture",
                                    ImmutableMap.of(
                                            "left", scrollArea.get("left"),
                                            "top", scrollArea.get("top"),
                                            "width", scrollArea.get("width"),
                                            "height", scrollArea.get("height"),
                                            "direction", direction,
                                            "percent", percent,
                                            "speed", speed
                                    )
                            );
                }
        );
    }


    public ScrollFromAreaTask withScrollArea(Map<String, Integer> scrollArea) {
        //perform scroll with data: area
        this.scrollArea = scrollArea;
        return this;
    }

    public ScrollFromAreaTask andPercent(Float percent) {
        this.percent = percent;
        return this;
    }

    public ScrollFromAreaTask inDirection(String direction) {
        this.direction = direction;
        return this;
    }

    public ScrollFromAreaTask andSpeed(Float speed) {
        this.speed = speed;
        return this;
    }


}
