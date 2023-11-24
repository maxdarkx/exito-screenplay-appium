package co.com.sofka.certification.models;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.webdriver.WebDriverFacade;

import io.appium.java_client.AppiumDriver;

public class MobileAppiumDriver {

    public static AppiumDriver getDriver()
    {
        return (AppiumDriver) ((WebDriverFacade) Serenity.getDriver()).getProxiedDriver();
    }

    public static void enableMultiWindows()
    {
        AppiumDriver driver = getDriver();
        driver.setSetting("enableMultiWindows",true);
    }
}
