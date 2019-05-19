package vn.hcmut.master.smartlibrary.dao;

import java.util.List;

public interface BasicDao<T> {
    List<T> findAll();

    T findById(Long id);

    T create(T obj);

    T update(T obj);

    void delete(T obj);
}
