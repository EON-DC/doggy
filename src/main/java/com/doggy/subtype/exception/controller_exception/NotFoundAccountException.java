package com.doggy.subtype.exception.controller_exception;

public class NotFoundAccountException extends RuntimeException {
    public NotFoundAccountException() {
        super();
    }

    public NotFoundAccountException(String message) {
        super(message);
    }

    public NotFoundAccountException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundAccountException(Throwable cause) {
        super(cause);
    }

    protected NotFoundAccountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
