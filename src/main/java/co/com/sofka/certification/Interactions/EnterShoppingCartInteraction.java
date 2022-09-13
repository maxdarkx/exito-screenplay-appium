package co.com.sofka.certification.Interactions;

import static co.com.sofka.certification.userinterfaces.MarketplaceUI.BT_VIEW_CART;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

public class EnterShoppingCartInteraction implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BT_VIEW_CART)
        );
    }

    public static EnterShoppingCartInteraction enterShoppingCart() {
        return new EnterShoppingCartInteraction();
    }
}
