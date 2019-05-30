package vn.hcmut.master.smartlibrary.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.hcmut.master.smartlibrary.model.Loan;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserProfile {
    private Long id;
    private String email;
    private String username;
    private String name;
    private Date createAt;
    private List<Loan> loans;
}
