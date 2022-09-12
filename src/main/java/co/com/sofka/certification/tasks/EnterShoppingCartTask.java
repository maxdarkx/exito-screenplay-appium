package co.com.sofka.certification.tasks;

import static co.com.sofka.certification.userinterfaces.MarketplaceUI.BT_VIEW_CART;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class EnterShoppingCartTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BT_VIEW_CART)
        );
    }

    public static EnterShoppingCartTask enterShoppingCart() {
        return new EnterShoppingCartTask();
    }
}
