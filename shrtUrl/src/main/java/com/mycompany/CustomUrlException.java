package com.mycompany;

/**
 * Custom exception to inform about that custom url is already in use
 */
public class CustomUrlException extends Exception {

    public CustomUrlException(String message) {
        super(message);
    }
}
