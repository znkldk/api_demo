package org.example;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.logging.Logger;

public class CustomTitle extends Methods{
    private static java.util.logging.Logger logger = Logger.getLogger(Permissions.class.getName());

    private final By textBoxLeft=By.id("com.hmh.api:id/left_text_edit");
    private final By textBoxRight=By.id("com.hmh.api:id/right_text_edit");
    private final By navigationBarRight=By.xpath("//*[@resource-id='com.hmh.api:id/right_text']");
    private final By navigationBarLeft=By.xpath("//*[@resource-id='com.hmh.api:id/left_text']");


    @Step("Write left TextBox <text>")
    public void writeTextBoxLetf(String text){
        WebElement element=findElement(textBoxLeft);
        element.clear();
        element.sendKeys(text);
    }

    @Step("Write right TextBox <text>")
    public void writeTextBoxRight(String text){
        WebElement element=findElement(textBoxRight);
        element.clear();
        element.sendKeys(text);
        logger.info("Text :"+text+" Element: "+textBoxRight);
    }

    @Step("Check navigationbar texts <left> <right>")
    public void checkNavigatonBarTexts(String leftText,String rightText){
        Assert.assertEquals(
                leftText,
                findElement(navigationBarLeft).getText());
        Assert.assertEquals(
                rightText,
                findElement(navigationBarRight).getText()
        );
        logger.info("Navigation Bar Text Checked");
    }

    @Step("Check TextBoxs texts <left> <right>")
    public void checkTextBoxsTexts(String leftText,String rightText){
        Assert.assertEquals(
                leftText,
                findElement(textBoxLeft).getText());
        Assert.assertEquals(
                rightText,
                findElement(textBoxRight).getText()
        );
        logger.info("TextBoxs Texts Checked");
    }

}
