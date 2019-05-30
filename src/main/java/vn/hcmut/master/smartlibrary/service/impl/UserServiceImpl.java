package vn.hcmut.master.smartlibrary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.hcmut.master.smartlibrary.dao.LoanDao;
import vn.hcmut.master.smartlibrary.dao.UserDao;
import vn.hcmut.master.smartlibrary.dto.response.UserProfile;
import vn.hcmut.master.smartlibrary.exception.ResourceNotFoundException;
import vn.hcmut.master.smartlibrary.model.Loan;
import vn.hcmut.master.smartlibrary.model.User;
import vn.hcmut.master.smartlibrary.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    private final LoanDao loanDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, LoanDao loanDao) {
        this.userDao = userDao;
        this.loanDao = loanDao;
    }

    @Override
    public User create(User user) {
        return userDao.create(user);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userDao.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userDao.existsByEmail(email);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username).orElseThrow(
                () -> new ResourceNotFoundException("User", "username", username)
        );
    }

    @Override
    public UserProfile getProfile(String username) {
        User user = userDao.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        List<Loan> loans = loanDao.findByUserId(user.getId());

        UserProfile userProfile = new UserProfile();
        userProfile.setId(user.getId());
        userProfile.setEmail(user.getEmail());
        userProfile.setName(user.getName());
        userProfile.setUsername(user.getUsername());
        userProfile.setCreateAt(user.getCreateAt());
        userProfile.setLoans(loans);

        return userProfile;
    }
}
