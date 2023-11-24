package co.com.sofka.certification.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

public class SendToUI {
    public static Target BT_SEND_TO_HOME = Target.the("Button to send the sale to home").located(By.id("constraitLayout_user_address"));
    public static Target BT_PICK_AT_THE_SHOP = Target.the("Button to pick the sale at the requested shop").located(By.id("constraitLayout_buy_and_collect"));

    public static Target BT_CHOOSE_DPTO = Target.the("Button to select a department from the listView")
            .located(By.xpath("//android.widget.LinearLayout[@resource-id='com.exito.appcompania:id/CustomEditText_department']/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ImageButton"));
    public static Target BT_CHOOSE_CITY = Target.the("Button to select a city from the listView")
            .located(By.xpath("//android.widget.LinearLayout[@resource-id='com.exito.appcompania:id/CustomEditText_city']/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ImageButton"));

    public static Target TV_CHOOSE_DEPARTMENT = Target.the("List item containing the buyer's department")
            .locatedBy("//android.widget.TextView[contains(@text,'{0}')]");
    public static Target TV_CHOOSE_CITY = Target.the("List item containing the buyer's city")
            .locatedBy("//android.widget.TextView[contains(@text,'{0}')]");

    public static Target ET_ADDRESS = Target.the("EditText to input address")
            .located(By.xpath("//android.widget.EditText[1]"));
    public static Target BT_ADD_ADDRESS = Target.the("Button to add the address")
            .located(By.id("appCompatButton_add_address"));

}
