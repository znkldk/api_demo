package org.example;

import com.thoughtworks.gauge.Step;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;

import java.util.logging.Logger;

public class Scrollable extends Methods{

    private final By tabsArea=By.xpath("//*[@resource-id='android:id/tabs']");
    private final By lastTab=By.xpath("//*[@resource-id='android:id/tabs']//*[@text='TAB 30']");

    private final By tabContent=By.xpath("//*[@resource-id='android:id/tabcontent']/*");
    static Logger logger = Logger.getLogger(Permissions.class.getName());

    @Step("Scrool left until find Last Tab")
    public void scroolLeftUntilFindLastTab(){
        WebElement sabitElement = driver.findElement(tabsArea);
        Rectangle rect = sabitElement.getRect();
        int startX = rect.getX() + (rect.getWidth() / 4)*3;
        int startY = rect.getY() + rect.getHeight() / 2;

        Dimension size = driver.manage().window().getSize();
        int endX = size.width / 4;
        int endY = startY;

        for (int i = 0; i < 15; i++) {
            try {
                WebElement element = driver.findElement(lastTab);
                if (element.isDisplayed()) {
                    element.click();
                    return;
                } else {
                    new TouchAction(driver).longPress(PointOption.point(startX, startY))
                            .moveTo(PointOption.point(endX, endY))
                            .release()
                            .perform();
                }
            } catch (Exception e) {
                new TouchAction(driver).longPress(PointOption.point(startX, startY))
                        .moveTo(PointOption.point(endX, endY))
                        .release()
                        .perform();
            }
        }
        Assert.fail("Element Not found after 5 swipes");
    }

    @Step("Scrolable Check Last Tab content")
    public void tabContent(){
        String actualTabContex=findElement(tabContent).getText();
        Assert.assertEquals("Content for tab with tag Tab 30",actualTabContex);
    }
}
