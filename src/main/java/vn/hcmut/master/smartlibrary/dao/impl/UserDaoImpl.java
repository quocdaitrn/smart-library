package vn.hcmut.master.smartlibrary.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import vn.hcmut.master.smartlibrary.dao.UserDao;
import vn.hcmut.master.smartlibrary.dao.mapper.UserRowMapper;
import vn.hcmut.master.smartlibrary.model.User;
import vn.hcmut.master.smartlibrary.type.Sex;

import java.sql.SQLException;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public User findByUsernameOrEmail(String username, String email) {
        User user;
        try {
            String sql = "SELECT * FROM users WHERE username = ? OR email = ? LIMIT 1";
            user = (User) jdbcTemplate.queryForObject(
                    sql, new Object[] { username, email }, new UserRowMapper());
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found with username or email : " + username);
        }

        return user;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long id) {
        String sql = "SELECT * FROM users WHERE id = ? LIMIT 1";
        User user = (User) jdbcTemplate.queryForObject(
                sql, new Object[] { id }, new UserRowMapper());

        return user;
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
