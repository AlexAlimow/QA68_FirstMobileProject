package com.remindly.tests;

import com.remindly.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReminderTests extends TestBase {
    @BeforeMethod(enabled = false)
    public void precondition(){
        app.getMainScreen().tapOnAddReminder();
        app.getReminder().enterReminderTitle("Holiday");
    }

    @Test
    public void addReminderTitlePositiveTest(){
        app.getReminder().saveReminder();
        Assert.assertTrue(app.getMainScreen().isNoReminderTitlePresent().contains("Holiday"));
    }

    @Test
    public void addReminderDateTest(){
//        app.getReminder().tapOnDateField();
//        app.getReminder().swipeToMonth();
//        app.getReminder().selectDate();
//        app.getReminder().tapOnYear();
//        app.getReminder().swipeToYear();
//        app.getReminder().tapOk();
//        app.getReminder().saveReminder();
//
//        Assert.assertTrue(app.getMainScreen().isReminderDateTimePresent("14/1/2027"));
    }

    @Test
    public void OpenLicencesWindow(){
        app.getReminder().tapOnHamburger();
        app.getReminder().tapOnLicenses();
        Assert.assertTrue(app.getMainScreen().isReminderLicencesTextPresent().contains("NOTICES FOR LIBRARIES"));
    }
}
