package ua.goit.jdbс.repository;

import ua.goit.jdbс.dao.DevelopersDao;

import java.util.List;

public interface Repository<T> {
    void save(T entity);
    void update(T entity);
    T findById(Integer id);
    List<T> findAll();
}
