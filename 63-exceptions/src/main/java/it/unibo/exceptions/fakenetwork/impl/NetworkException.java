package it.unibo.exceptions.fakenetwork.impl;

import java.io.IOException;

public class NetworkException extends IOException {
    private final String message;

    public NetworkException(final String msg) {
        this.message = "Network error while sending message: " + msg;
    }

    public NetworkException() {
        this.message = "Network error: no response";
    }

    @Override
    public String toString() {
        return message;
    }
}
