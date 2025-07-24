package ru.otus.settings;

import java.io.File;

public abstract class AbsSettings {
    protected File propertyFile;

    public AbsSettings(String fileName) {
        String rootPath = System.getProperty("user.dir");
        propertyFile = new File(rootPath +"/src/main/resources/" + fileName);
    }
}
