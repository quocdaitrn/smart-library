package vn.hcmut.master.smartlibrary.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import vn.hcmut.master.smartlibrary.dao.UserDao;
import vn.hcmut.master.smartlibrary.dao.mapper.UserRowMapper;
import vn.hcmut.master.smartlibrary.model.User;
import vn.hcmut.master.smartlibrary.type.Sex;

import java.util.List;
import java.util.Optional;

@Component
public class UserDaoImpl implements UserDao {

    private Logger logger = LoggerFactory.getLogger(LibItemDaoImpl.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        User user;
        try {
            String sql = "SELECT * FROM users WHERE username = ? LIMIT 1";
            user = (User) jdbcTemplate.queryForObject(
                    sql, new Object[] { username }, new UserRowMapper());
        } catch (Exception e) {
            return Optional.empty();
        }

        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findByUsernameOrEmail(String username, String email) {
        User user;
        try {
            String sql = "SELECT * FROM users WHERE username = ? OR email = ? LIMIT 1";
            user = (User) jdbcTemplate.queryForObject(
                    sql, new Object[] { username, email }, new UserRowMapper());
        } catch (Exception e) {
            return Optional.empty();
        }

        return Optional.ofNullable(user);
    }

    @Override
    public boolean existsByUsername(String username) {
        return findByCondition("username", username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return findByCondition("email", email);
    }

    private boolean findByCondition(String key, String value) {
        String sql = "SELECT * FROM users WHERE " + key + " = ? LIMIT 1";
        try {
            User user = (User) jdbcTemplate.queryForObject(
                    sql, new Object[] { value }, new UserRowMapper());
            return user != null;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        String sql = "SELECT * FROM users WHERE id = ? LIMIT 1";

        User user;
        try {
            user = (User) jdbcTemplate.queryForObject(
                    sql, new Object[] { id }, new UserRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }

        return Optional.ofNullable(user);
    }

    @Override
    public User create(User obj) {
        String sex = obj.getSex() == Sex.MALE ? "M" : "F";

        jdbcTemplate.update("INSERT INTO users(name, username, email, sex, phone, password, role) VALUES (?, ?, ?, ?, ?, ?, ?)",
                obj.getName(), obj.getUsername(), obj.getEmail(), sex, obj.getPhone(), obj.getPassword(), obj.getRole().name());

        return obj;
    }

    @Override
    public User update(User obj) {
        return null;
    }

    @Override
    public void delete(User obj) {

    }
}
