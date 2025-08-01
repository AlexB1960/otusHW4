package ru.otus.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.otus.exception.BrowserNotSupportedException;
import ru.otus.factory.settings.ChromeDriverSettings;
import ru.otus.factory.settings.EdgeDriverSettings;
import ru.otus.factory.settings.FirefoxDriverSettings;
import ru.otus.factory.settings.ISettings;

public class WebDriverFactory {
    private String browser = System.getProperty("browser").toLowerCase().trim();

    public WebDriver create(String option) {
        WebDriver driver;
        switch(browser) {
            case "chrome": {
                ISettings set = new ChromeDriverSettings();
                driver = new ChromeDriver((ChromeOptions) set.settings(null, option));
                break;
            }
            case "firefox": {
                ISettings set = new FirefoxDriverSettings();
                driver = new FirefoxDriver((FirefoxOptions) set.settings(null, option));
                break;
            }
            case "edge": {
                ISettings set = new EdgeDriverSettings();
                driver = new EdgeDriver((EdgeOptions) set.settings(null, option));
                break;
            }
            case null, default: {
                throw new BrowserNotSupportedException(browser);
            }
        }
        if (option.toLowerCase().trim().equals("fullscreen")) {
            driver.manage().window().fullscreen();
            driver.manage().window().maximize();
        }
        return driver;
    }

}
