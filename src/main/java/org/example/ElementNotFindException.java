package org.example;

public class ElementNotFindException extends RuntimeException {
    public ElementNotFindException() {
    }

    public ElementNotFindException(String message) {
        super(message);
    }

    public ElementNotFindException(String message, Throwable cause) {
        super(message, cause);
    }

    public ElementNotFindException(Throwable cause) {
        super(cause);
    }

    public ElementNotFindException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
