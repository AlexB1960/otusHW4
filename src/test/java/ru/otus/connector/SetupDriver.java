package ru.otus.connector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.otus.settings.PropertiesSettings;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

public class SetupDriver {

    public static WebDriver startDriver(String param) {

        Map<String, String> urlSettings = null;
        String url = "";
        try {
            urlSettings = new PropertiesSettings("url.properties").getSettings();
            url = urlSettings.get("url");
        } catch (IOException | NullPointerException e) {
            System.out.println(e.getMessage());
        }

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
        driver.get(url);
        return driver;
    }
}
