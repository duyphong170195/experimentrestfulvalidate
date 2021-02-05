package com.example.experimentrestfulvalidate.exceptions;

/**
 * Exception thrown if state of model instance is invalid.
 *
 */
@SuppressWarnings("serial")
public class InvalidModelException extends RuntimeException {

    /**
     * Create instance with detailed message.
     *
     * @param message the detailed message
     */
    public InvalidModelException(String message) {
        super(message);
    }
}