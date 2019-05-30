package vn.hcmut.master.smartlibrary.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserLoan {
    private Long id;
    private Date borrowDate;
    private String note;
    private Date deadline;
    private Date returnDate;
    private ItemResponse item;
}
