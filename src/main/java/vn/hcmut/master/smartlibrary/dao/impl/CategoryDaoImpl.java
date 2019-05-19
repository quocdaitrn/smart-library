package vn.hcmut.master.smartlibrary.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import vn.hcmut.master.smartlibrary.dao.CategoryDao;
import vn.hcmut.master.smartlibrary.model.Category;

import java.util.List;

@Component
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public Category create(Category obj) {
        return null;
    }

    @Override
    public Category update(Category obj) {
        return null;
    }

    @Override
    public void delete(Category obj) {

    }
}
