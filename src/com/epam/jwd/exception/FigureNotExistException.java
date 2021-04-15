package com.epam.jwd.exception;

public class FigureNotExistException extends FigureException {
    public FigureNotExistException() {
        super();
    }

    public FigureNotExistException(String message) {
        super(message);
    }

    public FigureNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public FigureNotExistException(Throwable cause) {
        super(cause);
    }
}
