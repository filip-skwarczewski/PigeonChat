package me.skwaraa.exceptions;

public class EmailInvalidException extends Exception{
    public EmailInvalidException() {}

    public EmailInvalidException(String message) {
        super(message);
    }
}
