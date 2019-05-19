package vn.hcmut.master.smartlibrary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.hcmut.master.smartlibrary.dao.UserDao;
import vn.hcmut.master.smartlibrary.model.User;
import vn.hcmut.master.smartlibrary.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private UserDao userDao;

    @Override
    public User create(User user) {
        return userDao.create(user);
    }
}
