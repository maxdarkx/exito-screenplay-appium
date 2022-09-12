package co.com.sofka.certification.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.DriverTask;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.thucydides.core.webdriver.WebDriverFacade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class SendStringKeyCodesTask implements Task {
    private String wordToSend;
    private List<AndroidKey> codesToSend;

    @Override
    public <T extends Actor> void performAs(T actor) {
        codesToSend = decodeSequence(wordToSend);
        actor.attemptsTo(
                hitTheKeys(codesToSend)
        );
    }

    public static SendStringKeyCodesTask sendStringKeyCodes() {
        return new SendStringKeyCodesTask();
    }

    public SendStringKeyCodesTask fromTheWord(String word) {
        wordToSend = word;
        return this;
    }

    public Performable hitTheKeys(List<AndroidKey> codes) {
        return new DriverTask(
                webDriver ->
                {
                    AndroidDriver mobileDriver = (AndroidDriver) ((AppiumDriver) ((WebDriverFacade) webDriver).getProxiedDriver());
                    codesToSend.forEach(
                            code -> mobileDriver.pressKey(new KeyEvent(code))
                    );
                }
        );
    }

    public List<AndroidKey> decodeSequence(String codes) {
        List<AndroidKey> codeList = new ArrayList<AndroidKey>();
        String androidValue;
        for (char value : codes.toCharArray()) {
            androidValue = String.valueOf(value).toUpperCase(Locale.ROOT);
            switch (androidValue) {
                case (" "):
                    codeList.add(AndroidKey.SPACE);
                    break;
                case ("0"):
                    codeList.add(AndroidKey.DIGIT_0);
                    break;
                case ("1"):
                    codeList.add(AndroidKey.DIGIT_1);
                    break;
                case ("2"):
                    codeList.add(AndroidKey.DIGIT_2);
                    break;
                case ("3"):
                    codeList.add(AndroidKey.DIGIT_3);
                    break;
                case ("4"):
                    codeList.add(AndroidKey.DIGIT_4);
                    break;
                case ("5"):
                    codeList.add(AndroidKey.DIGIT_5);
                    break;
                case ("6"):
                    codeList.add(AndroidKey.DIGIT_6);
                    break;
                case ("7"):
                    codeList.add(AndroidKey.DIGIT_7);
                    break;
                case ("8"):
                    codeList.add(AndroidKey.DIGIT_8);
                    break;
                case ("9"):
                    codeList.add(AndroidKey.DIGIT_9);
                    break;
                case ("*"):
                    codeList.add(AndroidKey.STAR);
                    break;
                case ("#"):
                    codeList.add(AndroidKey.POUND);
                    break;
                case (","):
                    codeList.add(AndroidKey.COMMA);
                    break;
                case ("."):
                    codeList.add(AndroidKey.PERIOD);
                    break;
                case ("-"):
                    codeList.add(AndroidKey.MINUS);
                    break;
                case ("="):
                    codeList.add(AndroidKey.EQUALS);
                    break;
                case ("+"):
                    codeList.add(AndroidKey.PLUS);
                    break;
                case ("/"):
                    codeList.add(AndroidKey.SLASH);
                    break;
                case ("\\"):
                    codeList.add(AndroidKey.BACKSLASH);
                    break;
                case ("@"):
                    codeList.add(AndroidKey.AT);
                    break;
                default:
                    codeList.add(AndroidKey.valueOf(androidValue));
            }
        }
        codeList.add(AndroidKey.ENTER);
        return codeList;
    }
}
