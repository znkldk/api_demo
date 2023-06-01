package org.example;

import com.thoughtworks.gauge.Step;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.logging.Logger;

public class Notification extends Methods{
    private final String expandAndCloseBtn="/../..//*[@resource-id='android:id/expand_button_pill']";
    private final String appNotificationBaseXpath="//*[@resource-id='android:id/title' and @text='Joe']";
    private final String appNotificationExpandedTitleForCheck="/../..//*[@resource-id='android:id/app_name_text' and @text='API Demos']";
    private final String notificationContex="/../..//*[@resource-id='android:id/notification_main_column']//*[contains(@text,'meet u for dinner')]";
    static Logger logger = Logger.getLogger(Permissions.class.getName());

    @Step("Open Notifications")
    public void openNotifications(){
        ((AndroidDriver) driver).openNotifications();
        logger.info("Notification opened");

    }

    @Step("Click App Notification Expend Btn")
    public void clickNotification(){
        findElement(By.xpath(
                appNotificationBaseXpath
                        +expandAndCloseBtn)).click();
        logger.info("Notification Expended");
    }

    @Step("Check notification expand <trueOrClose>")
    public void checkNotificationExpand(boolean bool){
        String xpath=appNotificationBaseXpath+appNotificationExpandedTitleForCheck;
        Assert.assertEquals(bool,doesElementExist(By.xpath(xpath)));

    }

    @Step("Check notification Contex")
    public void checkNotificationContex(){
        String xpath=appNotificationBaseXpath+notificationContex;
        Assert.assertTrue("Contex Not Correct",doesElementExist(By.xpath(xpath)));
    }
}
