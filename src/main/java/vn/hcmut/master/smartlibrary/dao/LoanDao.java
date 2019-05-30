package vn.hcmut.master.smartlibrary.dao;

import vn.hcmut.master.smartlibrary.model.Loan;

import java.util.List;

public interface LoanDao extends BasicDao<Loan> {
    List<Loan> findByUserId(Long userId);

    void updateReturnDateByUserIdAndItemId(Long userId, Long libItemId);
}
