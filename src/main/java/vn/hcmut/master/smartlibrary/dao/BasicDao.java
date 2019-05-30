package vn.hcmut.master.smartlibrary.dao;

import java.util.List;
import java.util.Optional;

public interface BasicDao<T> {
    List<T> findAll();

    Optional<T> findById(Long id);

    T create(T obj);

    T update(T obj);

    void delete(T obj);
}
