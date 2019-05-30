package vn.hcmut.master.smartlibrary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.hcmut.master.smartlibrary.dao.LibItemDao;
import vn.hcmut.master.smartlibrary.dao.LoanDao;
import vn.hcmut.master.smartlibrary.dao.UserDao;
import vn.hcmut.master.smartlibrary.dto.request.LoanRequest;
import vn.hcmut.master.smartlibrary.exception.ResourceNotFoundException;
import vn.hcmut.master.smartlibrary.model.LibItem;
import vn.hcmut.master.smartlibrary.model.Loan;
import vn.hcmut.master.smartlibrary.model.User;
import vn.hcmut.master.smartlibrary.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanDao loanDao;
    private final UserDao userDao;
    private final LibItemDao libItemDao;

    @Autowired
    public LoanServiceImpl(LoanDao loanDao, UserDao userDao, LibItemDao libItemDao) {
        this.loanDao = loanDao;
        this.userDao = userDao;
        this.libItemDao = libItemDao;
    }

    @Override
    public Loan add(LoanRequest request) {
        User user = userDao.findById(request.getUserId()).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", request.getUserId())
        );

        LibItem libItem = libItemDao.findById(request.getLibItemId()).orElseThrow(
                () -> new ResourceNotFoundException("LibItem", "id", request.getLibItemId())
        );

        Loan loan = new Loan();
        loan.setUser(user);
        loan.setLibItem(libItem);
        loan.setBorrowDate(request.getBorrowDate());
        loan.setDueDate(request.getDueDate());
        loan.setNote(request.getNote());

        return loanDao.create(loan);
    }

    @Override
    public void makeReturned(LoanRequest request) {
        loanDao.updateReturnDateByUserIdAndItemId(request.getUserId(), request.getLibItemId());
    }
}
