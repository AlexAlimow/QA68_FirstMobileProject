package com.remindly.fw;

import com.remindly.core.BaseHelper;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ReminderHelper extends BaseHelper {

    public ReminderHelper(AppiumDriver driver) {
        super(driver);
    }

    public void enterReminderTitle(String text) {
        type(By.id("reminder_title"), text);
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

    public void tapOnDateField() {
        tap(By.id("date"));
    }

    public void swipeToMonth(String period, String month, int swipeCount) {
        pause(1000);

        if (!getSelectedMonth().equals(month)) {
            for (int i = 0; i < swipeCount; i++) {
                if (period.equals("future")) {
                    swipe(0.8, 0.4);
                } else if (period.equals("past")) {
                    swipe(0.5, 0.9);
                }
            }
        }
    }

    private String getSelectedMonth() {
        return isTextPresent(By.id("date_picker_month"));
    }

    public void selectDate(int index) {
        pause(1000);
        List<WebElement> days = driver.findElements(By.className("android.view.View"));
        days.get(index).click();
    }

    public void tapOnYear() {
        tap(By.id("date_picker_year"));
    }

    public void swipeToYear(String period, String year) {
        pause(1000);

        if (!getSelectedYear().equals(year)) {
            if (period.equals("future")) {
                untilNeededYear(year, 0.6, 0.5);
            } else if (period.equals("past")) {
                untilNeededYear(year, 0.5, 0.6);
            }
        }
        tap(By.id("month_text_view"));
    }

    private String getSelectedYear() {
        return isTextPresent(By.id("date_picker_year"));
    }

    private void untilNeededYear(String year, double start, double stop) {
        while (!getYear().equals(year)) {
            swipeInElement(By.className("android.widget.ListView"), start, stop);
        }
        getYear();
    }

    private String getYear() {
        return isTextPresent(By.id("month_text_view"));
    }

    public void tapOnOk() {
        tap(By.xpath("//*[@text='OK']"));
    }

    public void tapOnTimeField() {
        tap(By.id("time"));

    }

    public void selectTimeOfDay(String timeOfDay) {
        pause(500);
        if (timeOfDay.equals("am")) {
            tapWithCoordinates(280, 1344);
        } else if (timeOfDay.equals("pm")) {
            tapWithCoordinates(800, 1344);
        }
    }

    public void selectTime(int xHour, int yHour, int xMin, int yMin) {
        tapWithCoordinates(xHour, yHour);
        tapWithCoordinates(xMin, yMin);
    }

    public void switchOff() {
        tap(By.id("repeat_switch"));
    }


    public void tapOnRepetitionIntervalField() {
        tap(By.id("RepeatNo"));
    }

    public void enterInterval(String number) {
        pause(500);
        type(By.className("android.widget.EditText"), number);
        tapOnOk();
    }

    public void tapOnRepetitionField() {
        swipe(0.8, 0.5);
        tap(By.id("RepeatType"));
    }

    public void selectTypeOfRepetition(String typeOfRepetition) {
        tap(By.xpath("//*[@text='" + typeOfRepetition + "']"));
    }
}

