package ru.otus.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class AbsCommon {
    protected WebDriver driver;
    protected Actions actions;

    public AbsCommon(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    protected WebElement getElement(By locator, int delay) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(delay));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected List<WebElement> getElements(By locator, int delay) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(delay));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    protected boolean waiter(int delay) {
        boolean delayResult;
        try {
            Thread.sleep(Duration.ofSeconds(delay));
            delayResult = true;
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            delayResult = false;
        }
        return delayResult;
    }

}
