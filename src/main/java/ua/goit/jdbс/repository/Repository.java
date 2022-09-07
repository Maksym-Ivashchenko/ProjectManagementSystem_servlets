package ua.goit.jdbс.repository;

import ua.goit.jdbс.dao.DevelopersDao;

import java.util.List;

public interface Repository<T> {
    T save(T entity);
    void update(T entity);
    void delete(T entity);
    T findById(Integer id);
    List<T> findAll();
}
