package org.example;

import com.thoughtworks.gauge.Step;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.logging.Logger;

public class ContexMenu extends Methods{
    private final By longPressMeButton=By.id("com.hmh.api:id/long_press");
    private final By menuABtn=By.xpath("//*[@text='Menu A']");
    private final By menuBBtn=By.xpath("//*[@text='Menu B']");
    static Logger logger = Logger.getLogger(Permissions.class.getName());

    @Step("Long press Long Press Me Button")
    public void longPress(){
        longClickToElement(longPressMeButton);
    }

    @Step("Contex Menu Drop Down Elements Check")
    public void checkElementsForDropDown(){
        Assert.assertTrue("Menu A button cant found",
                doesElementExist(menuABtn));
        Assert.assertTrue("Menu B button cant found",
                doesElementExist(menuBBtn));
    }
}
