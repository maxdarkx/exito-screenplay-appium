package co.com.sofka.certification.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

public class CheckOutUI {
    public static Target BT_DO_CHECKOUT = Target.the("Button to checkout the shopping cart items")
            .located(By.xpath("//android.widget.TextView[contains(@text,'Finalizar compra')]"));
    public static Target ET_INSERT_USER_EMAIL = Target.the("EditText to insert client's email")
            .located(By.xpath("//android.widget.EditText[@hint = 'correo@email.com']"));
    public static Target BT_CONTINUE_TO_INSERT_USER_DATA = Target.the("Button to continue inserting user's data")
            .located(By.xpath("//android.widget.Button[@text = 'Confirmar']"));

    public static Target BT_PROCESS_PAYMENT = Target.the("Button to start payment")
            .located(By.xpath("//android.widget.Button[contains(@text, 'pagar')]"));

    //
    public static Target ET_INSERT_USER_FIRST_NAME = Target.the("EditText to insert client's firstname")
            .located(By.xpath("//android.widget.TextView[@text='*Nombre']/following::android.widget.EditText"));
    public static Target ET_INSERT_USER_LAST_NAME = Target.the("EditText to insert client's lastname")
            .located(By.xpath("//android.widget.TextView[@text='*Apellido']/following::android.widget.EditText"));
    public static Target ET_INSERT_USER_CELL_PHONE = Target.the("EditText to insert client's cellphone number")
            .located(By.xpath("//android.widget.TextView[@text='*Celular']/following::android.widget.EditText"));
    public static Target ET_INSERT_USER_ID = Target.the("EditText to insert client's id document")
            .located(By.xpath("//android.widget.TextView[@text='*Número']/following::android.widget.EditText"));

    public static Target CB_TERMS_AND_CONDITIONS = Target.the("CheckBox to agreed terms and conditions")
        .located(By.xpath("//android.widget.TextView[contains(@text,'datos personales')]/preceding::android.widget.CheckBox[2]"));

    public static Target CB_DATA_TREATMENT = Target.the("CheckBox to agreed data treatment")
            .located(By.xpath("//android.widget.TextView[contains(@text,'datos personales')]/preceding::android.widget.CheckBox[1]"));

    public static Target BT_CONTINUE_TO_SHIPPING = Target.the("Button to set package receiver's data")
            .located(By.xpath("//android.widget.Button[contains(@text, 'Continuar')]"));




    public static Target BT_GO_TO_SHIPPING = Target.the("Button to set package receiver's data")
            .located(By.xpath("//android.widget.Button[@resource-id = 'go-to-shipping']"));
    public static Target ET_SHIPPING_RECEIPT = Target.the("EditText to insert package receiver's name")
            .located(By.xpath("//android.widget.EditText[@resource-id = 'ship-receiverName']"));
    public static Target BT_GO_TO_PAYMENT = Target.the("Button to set payment data")
            .located(By.xpath("//android.widget.Button[@resource-id = 'btn-go-to-payment']"));
    public static Target ET_CLIENT_EMAIL = Target.the("EditText with the client's email")
            .located(By.xpath("//android.widget.EditText[@resource-id = 'client-email']")
            );


    public static Target GV_TOTAL = Target.the("GridView containing shipping cost and total sale")
            .located(By.xpath("//android.widget.GridView"));
    public static Target TV_SUBTOTAL = Target.the("TextView to show sale subtotal")
            .located(By.xpath("//android.view.View[@text = 'Subtotal:']/following-sibling::android.view.View"));

    public static Target TV_TOTAL = Target.the("TextView to show sale total")
            .located(By.xpath("//android.view.View[@text = 'Total:']/following-sibling::android.view.View"));

}
