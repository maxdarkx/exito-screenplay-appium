package co.com.sofka.certification.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

public class MarketplaceUI {
    public static Target ET_LOOK_FOR_ITEM = Target.the("EditText to look for an item into the marketplace")
            .located(By.id("com.exito.appcompania:id/TextInputEditText_keyword"));

    //use viewgroup 2 - 5 because viewgroup 1 is a menu.
    public static Target VG_ITEM = Target.the("ViewGroup containing the items {0}")
            .locatedBy("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[{0}]");
    public static Target BT_ADD_ITEM_TO_CART = Target.the("Button to add the item to the cart")
            .locatedBy("//android.view.ViewGroup/android.widget.TextView[contains(@text,'Agregar')]");
    public static Target BT_VIEW_CART = Target.the("Button to show the shopping cart")
            .located(By.id("com.exito.appcompania:id/appCompatImageView_shopping_cart"));
    public static Target BT_DO_CHECKOUT = Target.the("Button to checkout the shopping cart items")
            .located(By.xpath("//android.view.View[@content-desc=\"Ir a pagarFinalizar compra\"]"));
    public static Target TV_FINALIZE_SALE = Target.the("TextView tho show finalization of the sale")
            .located(By.xpath(""));


}
