package ru.otus.connector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SetupDriver {

    public WebDriver startDriver(String param) {
        String url_TestSite = System.getProperty("base.url");

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        if (param.equals("headless")) {
            options.addArguments("headless");
        }
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        if (param.equals("fullscreen")) {
            driver.manage().window().fullscreen();
            driver.manage().window().maximize();
        }
        driver.get(url_TestSite);
        return driver;
    }
}
