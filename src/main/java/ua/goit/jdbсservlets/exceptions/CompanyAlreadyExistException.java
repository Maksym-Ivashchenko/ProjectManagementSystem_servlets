package ua.goit.jdbсservlets.exceptions;

public class CompanyAlreadyExistException extends RuntimeException {
    public CompanyAlreadyExistException(String message) {
        super(message);
    }
}
