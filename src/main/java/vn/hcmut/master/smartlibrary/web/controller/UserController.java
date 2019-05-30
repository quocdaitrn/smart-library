package vn.hcmut.master.smartlibrary.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vn.hcmut.master.smartlibrary.dto.response.UserIdentityAvailability;
import vn.hcmut.master.smartlibrary.dto.response.UserProfile;
import vn.hcmut.master.smartlibrary.dto.response.UserSummary;
import vn.hcmut.master.smartlibrary.web.security.CurrentUser;
import vn.hcmut.master.smartlibrary.web.security.UserPrincipal;
import vn.hcmut.master.smartlibrary.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        return new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
    }

    @GetMapping("/checkUsernameAvailability")
    public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {
        Boolean isAvailable = !userService.existsByUsername(username);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/checkEmailAvailability")
    public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
        Boolean isAvailable = !userService.existsByEmail(email);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/{username}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public UserProfile getUserProfile(@PathVariable(value = "username") String username) {
        return userService.getProfile(username);
    }
}
