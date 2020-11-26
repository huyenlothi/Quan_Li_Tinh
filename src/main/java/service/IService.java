package service;

import com.quanli.exception.NotFoundException;

public interface IService<T> {
    Iterable<T> findAll();
    T save(T t);
    void delete(Long id);
    T findById(Long id) throws NotFoundException;
}
