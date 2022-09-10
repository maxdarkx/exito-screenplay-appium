package co.com.sofka.certification.Interactions;

import static co.com.sofka.certification.userinterfaces.MarketplaceUI.BT_ADD_ITEM_TO_CART;
import static co.com.sofka.certification.userinterfaces.MarketplaceUI.VG_ITEM;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

public class AddItemToCartInteraction implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BT_ADD_ITEM_TO_CART
                        .inside(VG_ITEM.of("2"))
                )
        );
    }

    public static AddItemToCartInteraction addItemToCart()
    {
        return new AddItemToCartInteraction();
    }
}
