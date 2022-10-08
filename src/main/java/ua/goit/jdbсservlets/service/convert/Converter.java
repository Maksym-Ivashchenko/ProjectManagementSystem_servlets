package ua.goit.jdbсservlets.service.convert;

public interface Converter<E, T>{

    E from(T entity);
    T to (E entity);
}
