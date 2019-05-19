package vn.hcmut.master.smartlibrary.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import vn.hcmut.master.smartlibrary.dao.LibSectionDao;
import vn.hcmut.master.smartlibrary.model.LibSection;

import java.util.List;

@Component
public class LibSectionDaoImpl implements LibSectionDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LibSection> findAll() {
        return null;
    }

    @Override
    public LibSection findById(Long id) {
        return null;
    }

    @Override
    public LibSection create(LibSection obj) {
        return null;
    }

    @Override
    public LibSection update(LibSection obj) {
        return null;
    }

    @Override
    public void delete(LibSection obj) {

    }
}
