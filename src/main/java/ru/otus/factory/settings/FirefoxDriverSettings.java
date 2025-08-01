package ru.otus.factory.settings;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxDriverSettings implements ISettings {

    @Override
    public AbstractDriverOptions settings(DesiredCapabilities desiredCapabilities, String... userArgs) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if (userArgs[0].toLowerCase().trim().equals("headless")) {
            firefoxOptions.addArguments("headless");
        }
        //firefoxOptions.merge(desiredCapabilities);
        return firefoxOptions;
    }
}
