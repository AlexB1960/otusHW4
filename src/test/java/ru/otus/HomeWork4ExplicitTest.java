package ru.otus;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeWork4ExplicitTest {
    private WebDriver webDriver;
    private static final Logger log = LogManager.getLogger(HomeWork4ExplicitTest.class);
    private final String URL = "https://otus.home.kartushin.su/training.html";
    private final By FIELD_TEXT = By.id("textInput");
    private final By MODAL_WINDOW_BUTTON = By.id("openModalBtn");
    private final By MODAL_WINDOW_CLOSE = By.id("closeModal");
    private final By MODAL_WINDOW = By.cssSelector("#myModal>div>h2");
    private final By FIELD_NAME = By.cssSelector("#sampleForm>#name");
    private final By FIELD_EMAIL = By.cssSelector("#sampleForm>#email");
    private final By BUTTON_SEND = By.cssSelector("#sampleForm>button");
    private final By MESSAGE_BOX = By.cssSelector("#messageBox");

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void starDriver() {
        ChromeOptions options = new ChromeOptions();
        log.info("Запуск вебдрайвера webDiver");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
    }

    @Test
    public void testN1() {
        endDriver();
        log.info("Старт 1 теста");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        log.info("Перезапуск вебдрайвера webDiver в headless режиме");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        webDriver.get(URL);
        WebElement fieldText = getElement(FIELD_TEXT);

        fieldText.sendKeys("OTUS");
        log.info("Проверка результата 1 теста");
        Assertions.assertEquals("OTUS", fieldText.getAttribute("value"));
    }

    @Test
    public void testN2() {
        log.info("Старт 2 теста");
        webDriver.manage().window().fullscreen();
        webDriver.manage().window().maximize();

        webDriver.get(URL);
        getElement(MODAL_WINDOW_BUTTON).click();

        WebElement modalWindow = getElement(MODAL_WINDOW);
        log.info("Проверка результата 2 теста");
        Assertions.assertTrue(modalWindow.isDisplayed());
        getElement(MODAL_WINDOW_CLOSE).click();
        Assertions.assertFalse(modalWindow.isDisplayed());
    }

    @Test
    public void testN3() {
        log.info("Старт 3 теста");
        webDriver.manage().window().fullscreen();
        webDriver.manage().window().maximize();

        webDriver.get(URL);
        getElement(FIELD_NAME).sendKeys("фыв");
        getElement(FIELD_EMAIL).sendKeys("asdf@sdfg.rt");
        getElement(BUTTON_SEND).click();

        WebElement messageBox = getElement(MESSAGE_BOX);
        log.info("Проверка результата 3 теста");
        Assertions.assertEquals("Форма отправлена с именем: фыв и email: asdf@sdfg.rt",
                                messageBox.getText());
    }

    private WebElement getElement(By locator) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    @AfterEach
    public void endDriver() {
        if (webDriver != null) {
            log.info("Завершение работы вебдрайвера webDriver");
            webDriver.close();
        }
    }
}
