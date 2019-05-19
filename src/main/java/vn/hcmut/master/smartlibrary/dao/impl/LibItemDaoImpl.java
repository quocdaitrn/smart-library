package vn.hcmut.master.smartlibrary.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import vn.hcmut.master.smartlibrary.dao.LibItemDao;
import vn.hcmut.master.smartlibrary.model.LibItem;

import java.util.List;

@Component
public class LibItemDaoImpl implements LibItemDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LibItem> findAll() {
        return null;
    }

    @Override
    public LibItem findById(Long id) {
        return null;
    }

    @Override
    public LibItem create(LibItem obj) {
        return null;
    }

    @Override
    public LibItem update(LibItem obj) {
        return null;
    }

    @Override
    public void delete(LibItem obj) {

    }
}
