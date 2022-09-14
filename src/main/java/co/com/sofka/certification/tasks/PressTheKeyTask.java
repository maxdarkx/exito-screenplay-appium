package co.com.sofka.certification.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.DriverTask;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class PressTheKeyTask implements Task {

    private AndroidKey keyCode;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                hitTheKey(keyCode)
        );
    }

    public static PressTheKeyTask press()
    {
        return new PressTheKeyTask();
    }

    public PressTheKeyTask theKey(AndroidKey code)
    {
        keyCode = code;
        return this;
    }

    public Performable hitTheKey(AndroidKey code)
    {
        return new DriverTask(
                webDriver -> {
                    ((AndroidDriver) webDriver).pressKey(new KeyEvent(code));
                }
        );
    }
}
