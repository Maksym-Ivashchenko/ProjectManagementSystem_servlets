package ua.goit.jdbсservlets.repository;

import java.util.List;

public interface Repository<T> {
    T save(T entity);
    T update(T entity);
    void delete(T entity);
    T findById(Integer id);
    List<T> findAll();
}
