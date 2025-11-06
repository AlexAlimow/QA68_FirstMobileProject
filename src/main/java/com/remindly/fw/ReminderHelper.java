package com.remindly.fw;

import com.remindly.core.BaseHelper;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ReminderHelper extends BaseHelper {

    public ReminderHelper(AppiumDriver driver) {
        super(driver);
    }

    public void enterReminderTitle(String text) {
        type(By.id("reminder_title"),text);
    }

    public void saveReminder() {
        tap(By.id("save_reminder"));
    }

    public void tapOnHamburger() {
        tap(By.xpath("//android.widget.ImageView[@content-desc=\"More options\"]"));
    }

    public void tapOnLicenses() {
        tap(By.xpath("//android.widget.LinearLayout"));
    }
}
