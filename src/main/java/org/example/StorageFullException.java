package org.example;

public class StorageFullException extends RuntimeException {
    public StorageFullException() {
    }

    public StorageFullException(String message) {
        super(message);
    }

    public StorageFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public StorageFullException(Throwable cause) {
        super(cause);
    }

    public StorageFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
