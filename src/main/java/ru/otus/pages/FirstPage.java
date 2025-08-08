package ru.otus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstPage extends AbsBasePage {
    private final By FIELD_TEXT = By.id("textInput");
    private final By MODAL_WINDOW_BUTTON = By.id("openModalBtn");
    private final By MODAL_WINDOW_CLOSE = By.id("closeModal");
    private final By MODAL_WINDOW = By.id("myModal"); //By.cssSelector(#myModal>div>h2");
    private final By FIELD_NAME = By.id("name");
    private final By FIELD_EMAIL = By.id("email");
    private final By BUTTON_SEND = By.cssSelector("#sampleForm>button");
    private final By MESSAGE_BOX = By.id("messageBox");

    public FirstPage(WebDriver driver) {
        super(driver, "/training.html");
    }

    public void openModalWindow() {
        getElement(MODAL_WINDOW_BUTTON).click();
    }

    public void assertOpenModalWindow() {
        assertThat(isAvailable(MODAL_WINDOW)).isTrue();
    }

    public void assertCloseModalWindow() {
        assertThat((notAvailable(MODAL_WINDOW))).isTrue();
    }

    public void fillForm() {
        getElement(FIELD_NAME).sendKeys("фыв");
        getElement(FIELD_EMAIL).sendKeys("asdf@sdfg.rt");
    }

    public void sendForm() {
        getElement(BUTTON_SEND).click();
    }

    public void assertMessageBox() {
        if (isAvailable(MESSAGE_BOX)) {
            String actualText = getElement(MESSAGE_BOX).getText();
            assertThat(actualText).isEqualTo("Форма отправлена с именем: фыв и email: asdf@sdfg.rt");
        }
    }

    public void inputText() {
        getElement(FIELD_TEXT).sendKeys("OTUS");
    }

    public void assertInputText() {
        if (isAvailable(FIELD_TEXT)) {
            String actualText = getElement(FIELD_TEXT).getAttribute("value");
            assertThat(actualText).isEqualTo("OTUS");
        }
    }

}
