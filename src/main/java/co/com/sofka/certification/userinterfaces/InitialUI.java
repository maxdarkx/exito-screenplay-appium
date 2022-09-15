package co.com.sofka.certification.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

public class InitialUI {
    public static Target BT_START_SESSION_LATER = Target.the("Button to start session later")
            .located(By.id("textView_loginlater"));
    public static Target BT_ALLOW_DETECT_LOCATION_WHILE_USING_APP = Target.the("Button to allow the app to access gps")
            .located(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
    public static Target BT_SKIP_TUTORIAL = Target.the("Button skip the app tutorial")
            .located(By.id("textView_onboarding_omitir"));
    //public static Target BT_CLOSE_IMAGE_PROPAGANDA = Target.the("Button skip the image propaganda in the lower side of the screen")
    //        .located(By.id("imageview_close"));
   public static Target BT_CLOSE_IMAGE_PROPAGANDA = Target.the("Button skip the image propaganda in the lower side of the screen")
            .located(By.xpath("//android.view.ViewGroup[@resource-id='com.exito.appcompania:id/constraintlayout_card_video']/android.widget.ImageView"));
    public static Target BT_SALES_MENU = Target.the("Button to show the sales menu")
            .located(By.id("third_item"));

}
