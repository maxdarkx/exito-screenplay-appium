package co.com.sofka.certification.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

public class SendToUI {
    //Send to address
    public static Target BT_SEND_TO_HOME = Target.the("Button to send the sale to home")
            .located(By.id("constraitLayout_user_address"));
    public static Target BT_CHOOSE_CITY = Target.the("Button to select a city from the listView")
            .located(By.xpath("//android.widget.Spinner[@resource-id = 'com.exito.appcompania:id/filled_exposed_dropdown_city']"));
    public static Target TV_CHOOSE_CITY = Target.the("List item containing the buyer's city")
            .locatedBy("//android.widget.TextView[contains(@text,'{0}')]");
    public static Target ET_ADDRESS = Target.the("EditText to input address")
            .located(By.xpath("//android.widget.EditText[1]"));
    public static Target BT_ADD_ADDRESS = Target.the("Button to add the address")
            .located(By.id("appCompatButton_add_address"));

    //send to local store
    public static Target BT_SEND_TO_LOCAL_STORE = Target.the("Button to pick the sale at the requested shop")
            .located(By.id("constraitLayout_buy_and_collect"));
    public static Target SP_CHOOSE_LOCAL_STORE = Target.the("Button to pick the sale at the requested shop")
            .located(By.id("filled_exposed_dropdown_store"));
    public static Target LIST_LOCAL_STORES_AVAILABLE = Target.the("Button to pick the sale at the requested shop")
            .located(By.id("txtDropDownLabel"));
    public static Target BT_CONTINUE = Target.the("Button to finish store selection")
            .located(By.id("appCompatButton_continue"));


}
