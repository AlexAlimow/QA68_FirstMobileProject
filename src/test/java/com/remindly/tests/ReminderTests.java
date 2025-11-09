package com.remindly.tests;

import com.remindly.core.TestBase;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReminderTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        app.getMainScreen().tapOnAddReminder();
        app.getReminder().enterReminderTitle("Holiday");
    }

    @Test
    public void addReminderTitlePositiveTest() {
        app.getReminder().saveReminder();
        Assert.assertTrue(app.getMainScreen().isNoReminderTitlePresent().contains("Holiday"));
    }

    @Test
    public void addReminderDateTest() {
        app.getReminder().tapOnDateField();
        app.getReminder().swipeToMonth("future", "JAN", 2);
        app.getReminder().selectDate(13);
        app.getReminder().tapOnYear();
        app.getReminder().swipeToYear("future", "2027");
        app.getReminder().tapOnOk();
        app.getReminder().saveReminder();

        Assert.assertTrue(app.getMainScreen().isReminderDateTimePresent().contains("14/1/2027"));
    }


    @Test
    public void addReminderTimeTest() {
        app.getReminder().tapOnTimeField();
        app.getReminder().selectTimeOfDay("pm");
        app.getReminder().selectTime(538, 1207, 538, 657);
        app.getReminder().tapOnOk();
        app.getReminder().saveReminder();

        Assert.assertTrue(app.getMainScreen().isReminderDateTimePresent().contains("18:00"));
    }

    @Test
    public void addReminderWithRepeatOffTest() {
        app.getReminder().switchOff();
        app.getReminder().saveReminder();

        Assert.assertTrue(app.getMainScreen().isRepeatInfoPresent().contains("Repeat Off"));
    }

    @Test
    public void addReminderWithRepetitionIntervalTest() {
        app.getReminder().tapOnRepetitionIntervalField();
        app.getReminder().enterInterval("2");
        app.getReminder().saveReminder();

        Assert.assertTrue(app.getMainScreen().isRepeatInfoPresent().contains("2"));
    }

    @Test
    public void addTypeOfRepetitionTest() {
        app.getReminder().tapOnRepetitionField();
        app.getReminder().selectTypeOfRepetition("Week");
        app.getReminder().saveReminder();

        Assert.assertTrue(app.getMainScreen().isRepeatInfoPresent().contains("Week"));
    }

    @Test
    public void deleteReminderTest() {
        app.getReminder().saveReminder();
        app.getMainScreen().deleteReminder();

        Assert.assertFalse(app.getMainScreen().isReminderTitlePresent("Holiday"));
    }

}
