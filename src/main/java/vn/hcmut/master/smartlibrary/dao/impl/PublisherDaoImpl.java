package vn.hcmut.master.smartlibrary.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import vn.hcmut.master.smartlibrary.dao.PublisherDao;
import vn.hcmut.master.smartlibrary.dao.mapper.PublisherRowMapper;
import vn.hcmut.master.smartlibrary.model.Publisher;

import java.util.List;
import java.util.Optional;

@Component
public class PublisherDaoImpl implements PublisherDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PublisherDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Publisher> findAll() {
        return null;
    }

    @Override
    public Optional<Publisher> findById(Long id) {
        String sql = "SELECT * FROM publishers WHERE id = ? LIMIT 1";

        Publisher publisher;
        try {
            publisher = (Publisher) jdbcTemplate.queryForObject(
                    sql, new Object[] { id }, new PublisherRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }

        return Optional.ofNullable(publisher);
    }

    @Override
    public Publisher create(Publisher obj) {
        return null;
    }

    @Override
    public Publisher update(Publisher obj) {
        return null;
    }

    @Override
    public void delete(Publisher obj) {

    }
}
