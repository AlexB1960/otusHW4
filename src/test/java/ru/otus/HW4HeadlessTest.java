package ru.otus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.otus.connector.SetupDriver;

import java.time.Duration;

public class HW4HeadlessTest {
    private WebDriver webDriver;
    private SetupDriver setupDriver = new SetupDriver();
    private final Logger log = LogManager.getLogger(HW4HeadlessTest.class);
    //public final String URL = "https://otus.home.kartushin.su/training.html";
    private final By FIELD_TEXT = By.id("textInput");


    @BeforeEach
    public void setDriver() {
        log.info("Запуск вебдрайвера webDriver в режиме headless");
        //webDriver = SetupDriver.startDriver("headless");
        webDriver = setupDriver.startDriver("headless");
    }

    @AfterEach
    public void endDriver() {
        if (webDriver != null) {
            log.info("Завершение работы вебдрайвера webDriver");
            webDriver.close();
        }
    }

    @Test
    public void fieldTextTest() {
        log.info("Старт 1 теста - текстового поля");
        WebElement fieldText = getElement(FIELD_TEXT);

        fieldText.sendKeys("OTUS");
        log.info("Проверка результата 1 теста - текстового поля");
        Assertions.assertEquals("OTUS", fieldText.getAttribute("value"));
    }

    private WebElement getElement(By locator) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
