package ru.otus.pages;

import org.openqa.selenium.WebDriver;
import ru.otus.common.AbsCommon;

public abstract class AbsBasePage extends AbsCommon {
    private String baseUrl = System.getProperty("base.url");
    private String path;

    public AbsBasePage(WebDriver driver, String path) {
        super(driver);
        this.path = path;
    }

    public void open() {
        super.driver.get(baseUrl + path);
    }

}
