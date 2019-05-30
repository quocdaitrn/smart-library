package vn.hcmut.master.smartlibrary.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vn.hcmut.master.smartlibrary.dto.request.LoanRequest;
import vn.hcmut.master.smartlibrary.dto.response.ApiResponse;
import vn.hcmut.master.smartlibrary.web.security.CurrentUser;
import vn.hcmut.master.smartlibrary.web.security.UserPrincipal;
import vn.hcmut.master.smartlibrary.service.LoanService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> borrow(@Valid @RequestBody LoanRequest request, @CurrentUser UserPrincipal currentUser) {
        loanService.add(request);

        return ResponseEntity.status(201)
                .body(new ApiResponse(true, "Loan added successfully"));
    }

    @PutMapping("/mark-return")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> returnItem(@Valid @RequestBody LoanRequest request, @CurrentUser UserPrincipal currentUser) {
        loanService.makeReturned(request);

        return ResponseEntity.status(200)
                .body(new ApiResponse(true, "Success"));
    }
}
