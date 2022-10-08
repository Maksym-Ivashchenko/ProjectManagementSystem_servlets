package ua.goit.jdbсservlets.exceptions;

public class ProjectAlreadyExistException extends RuntimeException {
    public ProjectAlreadyExistException(String message) {
        super(message);
    }
}
