package vn.hcmut.master.smartlibrary.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import vn.hcmut.master.smartlibrary.dao.LoanDao;
import vn.hcmut.master.smartlibrary.model.Loan;

import java.util.List;

@Component
public class LoanDaoImpl implements LoanDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Loan> findAll() {
        return null;
    }

    @Override
    public Loan findById(Long id) {
        return null;
    }

    @Override
    public Loan create(Loan obj) {
        return null;
    }

    @Override
    public Loan update(Loan obj) {
        return null;
    }

    @Override
    public void delete(Loan obj) {

    }
}
