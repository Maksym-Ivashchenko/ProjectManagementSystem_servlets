package ua.goit.jdbсservlets.exceptions;

public class SkillAlreadyExistException extends RuntimeException {
    public SkillAlreadyExistException(String message) {
        super(message);
    }
}
