package org.example;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;

import java.util.logging.Logger;

public class Permissions extends Methods{
    private By contunioBtn=By.id("com.android.permissioncontroller:id/continue_button");
    private By popUpOkBtn=By.id("android:id/button1");
    static Logger logger = Logger.getLogger(Permissions.class.getName());

    @Step("Allow")
    public void allow(){
        clickElementIfExist(contunioBtn);
        clickElementIfExist(popUpOkBtn);
        logger.info("Allow Section Passed");
    }

}
