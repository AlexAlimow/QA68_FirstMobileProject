package com.remindly.core;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class TestBase {

    protected AppManager app = new AppManager();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        app.init();
        app.getMainScreen().confirm();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }
}
