package org.example;

import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.ExecutionContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

public class Driver {
    public static AppiumDriver driver;
    private static java.util.logging.Logger logger = Logger.getLogger(Permissions.class.getName());

    private final String scenariosToNoResetTrue=
            "Scenario 3"+
            "Scenario 4"+
            "Scenario 5"+
            "Scenario 6";
    @BeforeScenario
    public void Android_setUp(ExecutionContext context) throws MalformedURLException {
        String currentScenarioName=context.getCurrentScenario().getName();

        logger.info("----------Starting---------");
        logger.info("----------"+currentScenarioName+"---------");

        boolean noReset=false;

        if (scenariosToNoResetTrue.contains(currentScenarioName)){
            noReset=true;
        }
        setDriver(noReset);

    }

    private void setDriver(Boolean noReset) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("appium:platformVersion", "10");
        capabilities.setCapability("appium:udid", "emulator-5554");
        capabilities.setCapability("appium:deviceName", "Android Emulator");
        capabilities.setCapability("appium:platformName", "Android");
        capabilities.setCapability("appium:noReset", noReset);

        capabilities.setCapability("appium:appPackage", "com.hmh.api");
        capabilities.setCapability("appium:appActivity", "com.hmh.api.ApiDemos");
        capabilities.setCapability("appium:ensureWebviewsHavePages", true);
        capabilities.setCapability("appium:nativeWebScreenshot", true);
        capabilities.setCapability("appium:newCommandTimeout", "3600");
        capabilities.setCapability("appium:connectHardwareKeyboard", true);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
        logger.info("Driver set success");

    }


}
