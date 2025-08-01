package ru.otus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstPage extends AbsBasePage {
    private final By FIELD_TEXT = By.id("textInput");
    private final By MODAL_WINDOW_BUTTON = By.id("openModalBtn");
    private final By MODAL_WINDOW_CLOSE = By.id("closeModal");
    private final By MODAL_WINDOW = By.cssSelector("#myModal>div>h2");
    private final By FIELD_NAME = By.id("name");
    private final By FIELD_EMAIL = By.id("email");
    private final By BUTTON_SEND = By.cssSelector("#sampleForm>button");
    private final By MESSAGE_BOX = By.id("messageBox");

    public FirstPage(WebDriver driver) {
        super(driver, "/training.html");
    }

    public void openModalWindow() {
        getElement(MODAL_WINDOW_BUTTON, 10).click();
    }

    public void assertOpenModalWindow() {
        WebElement modalWindow = getElement(MODAL_WINDOW, 10);
        waiter(1);
        assertThat(modalWindow.isDisplayed()).isTrue();
    }

    public void assertCloseModalWindow() {
        WebElement modalWindow = getElement(MODAL_WINDOW_CLOSE,10);
        modalWindow.click();
        waiter(1);
        assertThat(modalWindow.isDisplayed()).isFalse();
    }

    public void fillForm() {
        getElement(FIELD_NAME,10).sendKeys("фыв");
        getElement(FIELD_EMAIL, 10).sendKeys("asdf@sdfg.rt");
    }

    public void sendForm() {
        getElement(BUTTON_SEND,10).click();
    }

    public void assertMessageBox() {
        String actualText = getElement(MESSAGE_BOX,10).getText();
        waiter(1);
        assertThat(actualText).isEqualTo("Форма отправлена с именем: фыв и email: asdf@sdfg.rt");
    }

    public void inputText() {
        getElement(FIELD_TEXT,10).sendKeys("OTUS");
    }

    public void assertInputText() {
        String actualText = getElement(FIELD_TEXT,10).getAttribute("value");
        waiter(1);
        assertThat(actualText).isEqualTo("OTUS");
    }

}
