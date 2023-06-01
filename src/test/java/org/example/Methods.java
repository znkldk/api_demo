package org.example;

import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;

public class Methods extends Driver{

    static java.util.logging.Logger logger = Logger.getLogger(Permissions.class.getName());
    WebDriverWait wait = new WebDriverWait(driver, 12);


    public void clickElementByBy(By by){
        WebElement element=findElement(by);
        element.click();
    }

    public void clickElementIfExist(By by){
        WebElement element=null;
        if (doesElementExist(by)){
            element=findElement(by);
            element.click();
            logger.info("Element click By: "+by);
        }
    }

    public void writeTextByBy(By by,String text){
        WebElement element=findElement(by);
        element.sendKeys(text);
    }

    public WebElement findElement( By by) {
        WebElement webElement=null;

        try{
            webElement=wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }catch (Exception e){
            Assertions.fail("Element cant found Element: "+by);
        }
        return webElement;
    }

    public List<MobileElement> findElements(By by) {
        List<MobileElement> webElements=null;
        wait(1);
        try{
            webElements=driver.findElements(by);
        }catch (Exception e){
            Assertions.fail("Element cant found Element: "+by);
        }
        return  webElements;
    }

    public boolean doesElementExist ( By by) {
        WebElement webElement=null;

        try{
            webElement=wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            logger.info("Element Exists element: "+by);
            return true;
        }catch (Exception e){
            logger.info("Element Does Not Exists element: "+by);
        }
        return false;
    }

    public void wait(int seconds) {
        logger.info("Waiting... seconds: "+seconds);

        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement swipeAndFindElement(By by) {
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int startY = size.height / 2;
        int endY = startY / 4;

        for (int i = 0; i < 5; i++) {
            try {
                WebElement element = driver.findElement(by);
                if (element.isDisplayed()) {
                    return element;
                } else {
                    new TouchAction(driver).longPress(PointOption.point(x, startY))
                            .moveTo(PointOption.point(x, endY))
                            .release()
                            .perform();
                }
            } catch (Exception e) {
                new TouchAction(driver).longPress(PointOption.point(x, startY))
                        .moveTo(PointOption.point(x, endY))
                        .release()
                        .perform();
            }
        }
        Assert.fail("Element not found after 5 swipes");
        return null;
    }

    public void longClickToElement(By by){
        WebElement element=findElement(by);
        TouchAction touchAction=new TouchAction(driver);
        touchAction.longPress(LongPressOptions.longPressOptions()
                        .withElement(ElementOption.element(element))
                        .withDuration(Duration.ofSeconds(5)))
                .release()
                .perform();
        logger.info("long pressed to By: "+by);
    }

}
