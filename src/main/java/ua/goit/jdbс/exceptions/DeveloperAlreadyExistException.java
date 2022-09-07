package ua.goit.jdbс.exceptions;

public class DeveloperAlreadyExistException extends RuntimeException {
    public DeveloperAlreadyExistException(String message) {
        super(message);
    }
}
