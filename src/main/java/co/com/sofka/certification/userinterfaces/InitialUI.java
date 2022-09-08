package co.com.sofka.certification.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

public class InitialUI {
    public static Target BT_START_SESSION_LATER = Target.the("Button to start session later").located(By.id("textView_loginlater"));
    public static Target BT_ALLOW_DETECT_LOCATION_WHILE_USING_APP = Target.the("Button to allow the app to access gps").located(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
    public static Target BT_SKIP_TUTORIAL = Target.the("Button skip the app tutorial").located(By.id("textView_onboarding_omitir"));
    public static Target BT_CLOSE_IMAGE_PROPAGANDA = Target.the("Button skip the image propaganda in the lower side of the screen").located(By.id("imageview_close"));
    public static Target BT_SALES_MENU = Target.the("Button to show the sales menu").located(By.id("third_item"));
    public static Target BT_SEND_TO_HOME = Target.the("Button to send the sale to home").located(By.id("constraitLayout_user_address"));
    public static Target BT_PICK_AT_THE_SHOP = Target.the("Button to pick the sale at the requested shop").located(By.id("constraitLayout_buy_and_collect"));

    public static Target BT_CHOOSE_CITY = Target.the("Button to select a city from the listView").located(By.id("text_input_end_icon"));
    public static Target TV_CHOOSE_CITY = Target.the("List item containing the buyer's city").locatedBy("//android.widget.TextView[contains(@text,'{0}')]");


}
