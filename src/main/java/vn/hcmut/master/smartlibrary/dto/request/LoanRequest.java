package vn.hcmut.master.smartlibrary.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class LoanRequest {
    private Long id;
    private Long memberId;
    private Long libItemId;
    private Date borrowDate;
    private String note;
}
