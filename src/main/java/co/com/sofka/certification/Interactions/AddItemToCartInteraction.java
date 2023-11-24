package co.com.sofka.certification.Interactions;

import static co.com.sofka.certification.userinterfaces.MarketplaceUI.BT_ADD_ITEM_TO_CART;
import static co.com.sofka.certification.userinterfaces.MarketplaceUI.TV_ITEM_PRICE;
import static co.com.sofka.certification.userinterfaces.MarketplaceUI.VG_ITEM;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class AddItemToCartInteraction implements Interaction {
    Logger LOGGER = LoggerFactory.getLogger(AddItemToCartInteraction.class);
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(VG_ITEM.of("1"),isVisible()).forNoMoreThan(Duration.ofSeconds(15)),
                Click.on(BT_ADD_ITEM_TO_CART
                        .inside(VG_ITEM.of("1"))
                )
        );
        String price = TV_ITEM_PRICE.inside(VG_ITEM.of("1")).resolveFor(actor).getText();
        actor.remember("itemPrice",price);
        LOGGER.info("item List Price: "+ price);
    }

    public static AddItemToCartInteraction addItemToCart()
    {
        return new AddItemToCartInteraction();
    }
}
