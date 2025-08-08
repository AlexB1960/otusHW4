package ru.otus.first;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import ru.otus.pages.FirstPage;

public class FirstPageFullscreenTest extends AbsBaseTestSuite {
    private final Logger log = LogManager.getLogger(FirstPageFullscreenTest.class);

    public FirstPageFullscreenTest() {
        super.mode = "fullscreen";
    }

    @Test
    public void modalWindowTest() {
        FirstPage firstPage = new FirstPage(driver);
        firstPage.open();
        log.info("Старт 2 теста - открытие модального окна");
        firstPage.assertCloseModalWindow();
        firstPage.openModalWindow();
        log.info("Проверка результата 2 теста - открытие модального окна");
        firstPage.assertOpenModalWindow();
    }

    @Test
    public void sendMessageTest() {
        FirstPage firstPage = new FirstPage(driver);
        firstPage.open();
        log.info("Старт 3 теста - форма отправления динамического сообщения");
        firstPage.fillForm();
        firstPage.sendForm();
        log.info("Проверка результата 3 теста - форма отправления динамического сообщения");
        firstPage.assertMessageBox();
    }

}
