package ru.otus.first;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import ru.otus.pages.FirstPage;

public class FirstPageHeadlessTest extends AbsBaseTestSuite {
    private final Logger log = LogManager.getLogger(FirstPageHeadlessTest.class);

    public FirstPageHeadlessTest() {
        super.mode = "headless";
    }

    @Test
    public void fieldTextTest() {
        FirstPage firstPage = new FirstPage(driver);
        firstPage.open();
        log.info("Старт 1 теста - ввод в текстовое поле");
        firstPage.inputText();
        log.info("Проверка результата 1 теста - ввод в текстовое поле");
        firstPage.assertInputText();
    }

}
