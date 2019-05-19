package vn.hcmut.master.smartlibrary.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.hcmut.master.smartlibrary.dto.response.ApiResponse;
import vn.hcmut.master.smartlibrary.model.User;
import vn.hcmut.master.smartlibrary.service.MemberService;
import vn.hcmut.master.smartlibrary.dto.request.MemberRequest;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    public ResponseEntity<?> createMember(@RequestBody MemberRequest memberRequest) {
        User userFromRequest = new User();
        userFromRequest.setName(memberRequest.getName());
        userFromRequest.setEmail(memberRequest.getEmail());
        userFromRequest.setSex(memberRequest.getSex());
        userFromRequest.setPhone(memberRequest.getPhone());
        userFromRequest.setPassword(memberRequest.getPassword());

        User user = memberService.create(userFromRequest);

        return ResponseEntity.status(201).body(new ApiResponse(true, "User created successfully"));
    }
}
