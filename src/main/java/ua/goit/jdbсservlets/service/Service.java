package ua.goit.jdbсservlets.service;

public interface Service<T> {
    T save(T entity);

    T update(T entity);

    void delete(T entity);

    T findById(Integer id);
}
