package co.com.sofka.certification.tasks;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static co.com.sofka.certification.Interactions.HideKeyboardInteraction.hideKeyboard;
import static co.com.sofka.certification.tasks.PressTheKeyTask.press;
import static co.com.sofka.certification.tasks.SendStringKeyCodesTask.sendStringKeyCodes;
import static co.com.sofka.certification.userinterfaces.MarketplaceUI.BT_ADD_ITEM_TO_CART;
import static co.com.sofka.certification.userinterfaces.MarketplaceUI.ET_LOOK_FOR_ITEM;
import static co.com.sofka.certification.userinterfaces.MarketplaceUI.VG_ITEM;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import io.appium.java_client.android.nativekey.AndroidKey;

public class LookForItemTask implements Task {
    private String word;

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(ET_LOOK_FOR_ITEM, isVisible()).forNoMoreThan(Duration.ofSeconds(10)),
                Click.on(ET_LOOK_FOR_ITEM),
                sendStringKeyCodes().fromTheWord(word),
                hideKeyboard()
        );
    }

    public static LookForItemTask lookFor()
    {
        return new LookForItemTask();
    }
    public LookForItemTask item(String item)
    {
        word = item;
        return this;
    }
}
