package vn.hcmut.master.smartlibrary.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.hcmut.master.smartlibrary.dao.UserDao;
import vn.hcmut.master.smartlibrary.model.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        User user = userDao.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);

        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userDao.findById(id);

        return UserPrincipal.create(user);
    }
}
