package vn.hcmut.master.smartlibrary.dao;

import vn.hcmut.master.smartlibrary.model.User;

public interface UserDao extends BasicDao<User> {
    User findByEmail(String email);
    User findByUsername(String username);
    User findByUsernameOrEmail(String username, String email);
}
