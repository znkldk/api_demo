package org.example;

import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.logging.Logger;

public class AlertDialogs extends Methods{

    private final By okCancelDialogMessageAlert=By.id("android:id/parentPanel");
    private static Logger logger = Logger.getLogger(Permissions.class.getName());


    @Step("Check Ok Cancel Dialog Message")
    public void checkAlertMessage(){
        Assert.assertTrue("There is no Alert Message",
                doesElementExist(okCancelDialogMessageAlert));
    }
}
