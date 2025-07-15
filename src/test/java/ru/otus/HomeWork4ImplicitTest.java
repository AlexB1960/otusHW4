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

import java.time.Duration;

public class HomeWork4ImplicitTest {
    private WebDriver webDriver;
    private static final Logger log = LogManager.getLogger(HomeWork4ImplicitTest.class);
    private final String URL = "https://otus.home.kartushin.su/training.html";

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void starDriver() {
        ChromeOptions options = new ChromeOptions();
        log.info("Запуск вебдрайвера webDiver");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        webDriver.get(URL);
        WebElement webElement = webDriver.findElement(By.id("textInput"));

        webElement.sendKeys("OTUS");
        log.info("Проверка результата 1 теста");
        Assertions.assertEquals("OTUS", webElement.getAttribute("value"));
    }

    @Test
    public void testN2() {
        log.info("Старт 2 теста");
        webDriver.manage().window().fullscreen();
        webDriver.manage().window().maximize();

        webDriver.get(URL);
        WebElement webElement = webDriver.findElement(By.id("openModalBtn"));
        webElement.click();

        WebElement webElement1 =webDriver.findElement(By.cssSelector("#myModal>div>h2"));
        log.info("Проверка результата 2 теста");
        Assertions.assertTrue(webElement1.isEnabled());
    }

    @Test
    public void testN3() {
        log.info("Старт 3 теста");
        webDriver.manage().window().fullscreen();
        webDriver.manage().window().maximize();

        webDriver.get(URL);
        WebElement webElement = webDriver.findElement(By.cssSelector("#sampleForm>#name"));
        webElement.sendKeys("фыв");
        WebElement webElement1 = webDriver.findElement(By.cssSelector("#sampleForm>#email"));
        webElement1.sendKeys("asdf@sdfg.rt");
        WebElement webElement2 = webDriver.findElement(By.cssSelector("#sampleForm>button"));
        webElement2.click();

        WebElement webElement3 = webDriver.findElement(By.cssSelector("#messageBox"));
        log.info("Проверка результата 3 теста");
        Assertions.assertEquals("Форма отправлена с именем: фыв и email: asdf@sdfg.rt",
                                webElement3.getText());
    }

    @AfterEach
    public void endDriver() {
        if (webDriver != null) {
            log.info("Завершение работы вебдрайвера webDriver");
            webDriver.close();
        }
    }
}
