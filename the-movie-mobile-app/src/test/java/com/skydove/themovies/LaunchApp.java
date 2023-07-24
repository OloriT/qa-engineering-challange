package com.skydove.themovies;

import cucumber.api.CucumberOptions;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class LaunchApp {


    AppiumDriver driver;

    public AppiumDriver getDriver() {
        return driver;
    }

    WebDriverWait wait;

    @BeforeTest
    public String init() throws MalformedURLException {
        driver = new AppiumDriver(new URL(Constants.APPIUM_URL), getCapabilities());

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(50000));
//        Long timeoutInSeconds = 50L;
//        driver.manage().timeouts().implicitlyWait(timeoutInSeconds, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String pageTitle = driver.findElement(By.className("android.widget.TextView")).getText();
        assertEquals("TheMovies", pageTitle);

        return pageTitle;

    }

    public DesiredCapabilities getCapabilities() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(Constants.PLATFORM_NAME, Constants.PLATFORM_NAME_VALUE);
        caps.setCapability(Constants.UDID, Constants.UDID_VALUE);
        caps.setCapability(Constants.AUTOMATION_NAME, Constants.AUTOMATION_NAME_VALUE);
        caps.setCapability(Constants.PLATFORM_VERSION, Constants.PLATFORM_VERSION_VALUE);
        caps.setCapability(Constants.DEVICE_NAME, Constants.DEVICE_NAME_VALUE);
        caps.setCapability(Constants.APP_ACTIVITY, Constants.APP_ACTIVITY_VALUE);
        caps.setCapability(Constants.APP_PACKAGE, Constants.APP_PACKAGE_VALUE);
        caps.setCapability(Constants.UNICODE_KEYBOARD, Constants.UNICODE_KEYBOARD_VALUE);
        caps.setCapability(Constants.RESET_KEYBOARD, Constants.RESET_KEYBOARD_VALUE);


        return caps;
    }


    @AfterTest
    public void tearDown(){
        if (null != driver){
            getDriver().quit();
        }
    }
}
