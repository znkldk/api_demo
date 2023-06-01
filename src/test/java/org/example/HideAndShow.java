package org.example;

import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.logging.Logger;

public class HideAndShow extends Methods{
    private final String baseXpath="//*[@text='Demonstration of hiding and showing fragments.']/../*[@class='android.widget.LinearLayout'][RANKHERE]";
    private final String buttonXpath="//*[@class='android.widget.Button' and @text='TEXTHERE']";
    private final String textBoxXpath="//*[@class='android.widget.EditText']";
    static Logger logger = Logger.getLogger(Permissions.class.getName());

    @Step("Hide And Show Click <buttonName> Button rank <rank>")
    public void clickHideButton(String buttonName,String rank){
        String xpath=(baseXpath+buttonXpath)
                .replaceAll("RANKHERE",rank)
                .replaceAll("TEXTHERE",buttonName);
        findElement(By.xpath(xpath)).click();
        wait(2);
    }

    @Step("Hide And Show Check Button Text <text> rank <rank>")
    public void checkButtonName(String text,String rank){
        String xpath=(baseXpath+buttonXpath)
                .replaceAll("RANKHERE",rank)
                .replaceAll("TEXTHERE",text);

        Assert.assertTrue("button text is not: "+text
                ,doesElementExist(By.xpath(xpath)));
    }

    @Step("Hide And Show Check TextBox rank <rank> expected <expected>")
    public void writeTextBox(String rank,boolean expected){
        String xpath=(baseXpath+textBoxXpath)
                .replaceAll("RANKHERE",rank);
        Assert.assertEquals(expected,doesElementExist(By.xpath(xpath)));
    }


}
