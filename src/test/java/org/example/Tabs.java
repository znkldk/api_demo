package org.example;

import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.logging.Logger;

public class Tabs extends Methods{
    private final By tabsDinamicXpath=By.xpath("//*[@resource-id='android:id/action_bar_container']//*[contains(@class,'ActionBar')]");
    private final By actionBarsTabsPathText=By.xpath("//*[@text='App/Action Bar/Action Bar Tabs']");

    private final String tabNamesDinamicXpath="//*[@resource-id='android:id/action_bar_container']//*[contains(@class,'ActionBar')]//*[contains(@text,'TEXTHERE')]";
    int tabCount=0;//This will be upgrade for all changes
    private static java.util.logging.Logger logger = Logger.getLogger(Tabs.class.getName());

    @Step("increase tab count")
    public void increaseTabCount(){
        tabCount++;
    }

    @Step("decraise tab count")
    public void decraiseTabCount(){
        tabCount--;
        if (tabCount<0){
            tabCount=0;
        }
    }

    @Step("Check Tabs count")
    public void checkTabCount(){
        wait(1); //adding tabs runs some animation waiting here won't be bad
        int tabsActualCount=findElements(tabsDinamicXpath).size();
        Assert.assertEquals(
                "Tab count not correct"
                ,tabCount
                ,tabsActualCount);

    }

    @Step("Does Toggle tab passive mode")
    public void checkToggleTabPassive(){
        Assert.assertTrue(
                "actionBar is not passive mode!!!"
                ,doesElementExist(actionBarsTabsPathText));
        logger.info("actionBar is passive mode");
    }

    @Step("Does Toggle tab NOT passive mode")
    public void checkToggleNotTabPassive(){
        Assert.assertFalse(
                "actionBar is passive mode!!!"
                ,doesElementExist(actionBarsTabsPathText));

        logger.info("actionBar is NOT passive mode");

    }

    @Step("Check Tab Names")
    public void checkTabNames(){
        String xpath;
        for (int i =0; i<tabCount-1;i++){

            xpath=tabNamesDinamicXpath
                    .replaceAll("TEXTHERE",String.valueOf(i));
            Assert.assertTrue(
                    "TAB did not found name: TAB "+String.valueOf(i)+"  \n xpath= "+xpath,
                    doesElementExist(By.xpath(xpath)));

        }
    }

    @Step("Make Tab Count 0")
    public void makeTabCountZero(){
        tabCount=0;
        logger.info("tabCount is zero");
    }



}
