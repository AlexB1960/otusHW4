package ru.otus.common;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
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

    protected WebElement getElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected List<WebElement> getElements(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected void clickElement(By locator) {
        getElement(locator).click();
    }

    protected boolean isAvailable(By element) {
        boolean elementStatus;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            elementStatus = true;
        } catch (TimeoutException e) {
            System.out.println(e.getMessage() + " Locator " + element + " is not available!");
            elementStatus = false;
        }
        return elementStatus;
    }

    protected boolean notAvailable(By element) {
        boolean elementStatus;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
            elementStatus = true;
        } catch (TimeoutException e) {
            System.out.println(e.getMessage() + " Locator " + element + " is yet available!");
            elementStatus = false;
        }
        return elementStatus;
    }

}
