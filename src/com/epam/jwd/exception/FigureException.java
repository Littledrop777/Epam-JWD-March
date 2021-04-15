package com.epam.jwd.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FigureException extends Exception {
    public static final Logger LOGGER = LogManager.getLogger(FigureException.class);

    public FigureException() {
        super();
        LOGGER.error(this.getMessage());
    }

    public FigureException(String message) {
        super(message);
        LOGGER.error(this.getMessage());
    }

    public FigureException(String message, Throwable cause) {
        super(message, cause);
        LOGGER.error(this.getMessage());
    }

    public FigureException(Throwable cause) {
        super(cause);
        LOGGER.error(this.getMessage());
    }
}
