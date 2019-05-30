package vn.hcmut.master.smartlibrary.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class LoanRequest {
    private Long id;
    @NotNull
    private Long userId;
    @NotNull
    private Long libItemId;
    private Date borrowDate;
    private Date dueDate;
    private Date returnDate;
    private String note;
}
