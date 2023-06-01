package org.example;
import com.thoughtworks.gauge.Step;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

public class StepImplementation extends Methods{

    private final String menuItemDinamicXpath="//*[@resource-id='android:id/text1' and @text='TEXTHERE']";
    private final String buttonsDinamicXpath="//*[(contains(@resource-id,'btn') or contains(@class,'Button')) and @text='TEXTHERE']";


    static java.util.logging.Logger logger = Logger.getLogger(Permissions.class.getName());

    @Step("Click menu item <name>")
    public void clickMenuItem(String name){
        By by =By.xpath(menuItemDinamicXpath.replaceAll("TEXTHERE",name));
        WebElement element=swipeAndFindElement(by);
        element.click();
        logger.info("Menu Item Clicked By:"+by);
    }

    @Step("Click button <name>")
    public void clickbutton(String name){
        By by =By.xpath(buttonsDinamicXpath.replaceAll("TEXTHERE",name));
        clickElementByBy(by);
        logger.info("Button Clicked By:"+by);

    }



    @Step("Wait <seconds>")
    public void waitBySeconds(int seconds){
        wait(seconds);
    }




}
