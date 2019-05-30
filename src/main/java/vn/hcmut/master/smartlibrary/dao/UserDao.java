package vn.hcmut.master.smartlibrary.dao;

import vn.hcmut.master.smartlibrary.model.User;

import java.util.Optional;

public interface UserDao extends BasicDao<User> {
    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameOrEmail(String username, String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
