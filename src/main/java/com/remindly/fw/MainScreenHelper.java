package com.remindly.fw;

import com.remindly.core.BaseHelper;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MainScreenHelper extends BaseHelper {

    public MainScreenHelper(AppiumDriver driver) {
        super(driver);
    }

    public void confirm() {
        tap(By.id("android:id/button1"));
    }

    public boolean isNoReminderTextPresent() {
        return isElementPresent(By.id("no_reminder_text"));
    }

    public void tapOnAddReminder() {
        tap(By.id("add_reminder"));
    }

    public String isNoReminderTitlePresent() {
        return isTextPresent(By.id("recycle_title"));
    }


    public String isReminderLicencesTextPresent() {
        return isTextPresent(By.id("com.blanyal.remindly:id/licenses_text_view"));
    }

    public String isReminderDateTimePresent() {
        return isTextPresent(By.id("recycle_date_time"));
    }

    public String isRepeatInfoPresent() {
        return isTextPresent(By.id("recycle_repeat_info"));
    }

    public void deleteReminder() {
        pause(500);

        longPressWithCoordinates(By.id("recycle_title"));
        tap(By.id("discard_reminder"));
    }

    public boolean isReminderTitlePresent(String title) {
        return isElementPresent(By.xpath("//*[@text='" + title + "']"));
    }
}
