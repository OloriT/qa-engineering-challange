package com.skydove.themovies;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

public class AppCapabilities {

    public DesiredCapabilities runCap() throws MalformedURLException {

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
}
