package ru.otus.exception;

public class BrowserNotSupportedException extends RuntimeException {
    public BrowserNotSupportedException(String browserName) {
        super(String.format("Browser %s is not supported", browserName));
    }

}
