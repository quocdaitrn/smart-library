package vn.hcmut.master.smartlibrary.service;

import vn.hcmut.master.smartlibrary.dto.response.UserProfile;
import vn.hcmut.master.smartlibrary.model.User;

import java.util.Optional;

public interface UserService {
    User create(User user);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    User findByUsername(String username);

    UserProfile getProfile(String username);
}
