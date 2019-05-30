package vn.hcmut.master.smartlibrary.service;

import vn.hcmut.master.smartlibrary.dto.request.LoanRequest;
import vn.hcmut.master.smartlibrary.model.Loan;

public interface LoanService {
    Loan add(LoanRequest request);

    void makeReturned(LoanRequest request);
}
