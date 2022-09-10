package co.com.sofka.certification.Interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.DriverTask;
import net.thucydides.core.webdriver.WebDriverFacade;

import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;

public class HideKeyboardInteraction implements Interaction {
    private String wordToSend;
    private List<AndroidKey> codesToSend;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                hideTheKeyboard()
        );
    }

    public static HideKeyboardInteraction hideKeyboard() {
        return new HideKeyboardInteraction();
    }

    public Performable hideTheKeyboard() {
        return new DriverTask(
                webDriver ->
                {
                    AndroidDriver mobileDriver =(AndroidDriver) ((AppiumDriver) ((WebDriverFacade) webDriver).getProxiedDriver());
                    mobileDriver.hideKeyboard();
                }
        );
    }
}
