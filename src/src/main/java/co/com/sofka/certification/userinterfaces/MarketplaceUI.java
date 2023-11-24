package co.com.sofka.certification.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

public class MarketplaceUI {
    public static Target ET_LOOK_FOR_ITEM = Target.the("EditText to look for an item into the marketplace")
            .located(By.id("com.exito.appcompania:id/TextInputEditText_keyword"));

    //use viewgroup 2 - 5 because viewgroup 1 is a menu.
    public static Target VG_ITEM = Target.the("ViewGroup containing the card item {0}")
            .locatedBy("//android.view.ViewGroup[@resource-id='com.exito.appcompania:id/constraintLayout_plp_item_top'][{0}]");
    public static Target BT_ADD_ITEM_TO_CART = Target.the("Button to add the item to the cart")
            .locatedBy("//android.widget.TextView[@resource-id='com.exito.appcompania:id/appCompatTextView_add_item']");
    public static Target TV_ITEM_PRICE = Target.the("TextView to show the item's price")
            .locatedBy("//android.widget.TextView[@resource-id='com.exito.appcompania:id/appCompatTextView_price']");
    public static Target BT_VIEW_CART = Target.the("Button to show the shopping cart")
            .located(By.id("com.exito.appcompania:id/appCompatImageView_shopping_cart"));

}
