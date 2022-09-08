package co.com.sofka.certification.runners;

import net.thucydides.core.webdriver.DriverSource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileAndroidDriver implements DriverSource {


     public WebDriver newDriver() {

        RemoteWebDriver driver;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"12");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        capabilities.setCapability(MobileCapabilityType.UDID,"emulator-5554");
        capabilities.setCapability(MobileCapabilityType.APP,"/home/juan/Escritorio/QASofkaWorkspace/Exito-screenplay-appium/src/test/resources/apk/Exito-315.apk");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.exito.appcompania");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.exito.appcompania.views.initialaccess.activities.SplashActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET,false);
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10000);
        //capabilities.setCapability("enableMultiWindows", true);


        try {
            driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            driver = new RemoteWebDriver(null);
        }
        return driver;
    }

    public boolean takesScreenshots() {
        return true;
    }
}
