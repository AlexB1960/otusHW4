package ru.otus.first;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import ru.otus.pages.FirstPage;

public class FirstPageFullscreenTest extends AbsBaseTestSuite {
    private final Logger log = LogManager.getLogger(FirstPageFullscreenTest.class);

    public FirstPageFullscreenTest() {
        this.mode = "fullscreen";
    }

    @Test
    public void modalWindowTest() {
        FirstPage firstPage = new FirstPage(driver);
        firstPage.open();
        log.info("Старт 2 теста - открытия модального окна");
        firstPage.openModalWindow();
        log.info("Проверка результата 2 теста - открытия модального окна");
        firstPage.assertOpenModalWindow();
    }

    @Test
    public void sendMessageTest() {
        FirstPage firstPage = new FirstPage(driver);
        firstPage.open();
        log.info("Старт 3 теста - формы отправления динамического сообщения");
        firstPage.fillForm();
        firstPage.sendForm();
        log.info("Проверка результата 3 теста - формы отправления динамического сообщения");
        firstPage.assertMessageBox();
    }

}
