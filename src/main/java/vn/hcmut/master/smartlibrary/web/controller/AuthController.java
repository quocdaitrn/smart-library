package vn.hcmut.master.smartlibrary.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vn.hcmut.master.smartlibrary.dao.UserDao;
import vn.hcmut.master.smartlibrary.dto.request.LoginRequest;
import vn.hcmut.master.smartlibrary.dto.request.SignUpRequest;
import vn.hcmut.master.smartlibrary.dto.response.ApiResponse;
import vn.hcmut.master.smartlibrary.dto.response.JwtAuthenticationResponse;
import vn.hcmut.master.smartlibrary.model.User;
import vn.hcmut.master.smartlibrary.security.JwtTokenProvider;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;
import java.util.Date;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDao userDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
//        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
//            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
//                    HttpStatus.BAD_REQUEST);
//        }
//
//        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
//            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
//                    HttpStatus.BAD_REQUEST);
//        }

        // Creating user's account
        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
                signUpRequest.getSex(), signUpRequest.getPhone(), signUpRequest.getPassword(), signUpRequest.getRole());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User result = userDao.create(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }
}