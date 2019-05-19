package vn.hcmut.master.smartlibrary.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.hcmut.master.smartlibrary.dto.request.LoanRequest;
import vn.hcmut.master.smartlibrary.model.Loan;
import vn.hcmut.master.smartlibrary.service.LoanService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    public List<Loan> list(@RequestBody LoanRequest request) {
        return new ArrayList<>();
    }
}
