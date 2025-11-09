package com.remindly.tests;

import com.remindly.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainScreenTests extends TestBase {

    @Test
    public void appLaunchTest(){
        Assert.assertTrue(app.getMainScreen().isNoReminderTextPresent());
    }

    @Test
    public void OpenLicencesWindow(){
        app.getReminder().tapOnHamburger();
        app.getReminder().tapOnLicenses();
        Assert.assertTrue(app.getMainScreen().isReminderLicencesTextPresent().contains("NOTICES FOR LIBRARIES"));
    }
}
