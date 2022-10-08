package ua.goit.jdbсservlets.exceptions;

public class DeveloperAlreadyExistException extends RuntimeException {
    public DeveloperAlreadyExistException(String message) {
        super(message);
    }
}
