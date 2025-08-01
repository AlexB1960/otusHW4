package ru.otus.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstPage extends AbsBasePage {
    private final By FIELD_TEXT = By.id("textInput");
    private final By MODAL_WINDOW_BUTTON = By.id("openModalBtn");
    private final By MODAL_WINDOW_CLOSE = By.id("closeModal");
    private final By MODAL_WINDOW = By.cssSelector("#myModal>div>h2");
    private final By FIELD_NAME = By.id("name"); //#sampleForm>#
    private final By FIELD_EMAIL = By.id("email"); //#sampleForm>#
    private final By BUTTON_SEND = By.cssSelector("#sampleForm>button");
    private final By MESSAGE_BOX = By.id("messageBox");

    public FirstPage(WebDriver driver) {
        super(driver, "/training.html");
    }

    public void openModalWindow() {
        getElement(MODAL_WINDOW_BUTTON).click();
    }

    public void assertOpenModalWindow() {
        WebElement modalWindow = getElement(MODAL_WINDOW);
        Assertions.assertTrue(modalWindow.isDisplayed());
        getElement(MODAL_WINDOW_CLOSE).click();
        Assertions.assertFalse(modalWindow.isDisplayed());
    }

    public void fillForm() {
        getElement(FIELD_NAME).sendKeys("фыв");
        getElement(FIELD_EMAIL).sendKeys("asdf@sdfg.rt");
    }

    public void sendForm() {
        getElement(BUTTON_SEND).click();
    }

    public void assertMessageBox() {
        WebElement messageBox = getElement(MESSAGE_BOX);
        Assertions.assertEquals("Форма отправлена с именем: фыв и email: asdf@sdfg.rt",
                messageBox.getText());
    }

    public void inputText() {
        getElement(FIELD_TEXT).sendKeys("OTUS");
    }

    public void assertInputText() {
        Assertions.assertEquals("OTUS", getElement(FIELD_TEXT).getAttribute("value"));
    }

}
