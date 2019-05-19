package vn.hcmut.master.smartlibrary.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.hcmut.master.smartlibrary.type.Sex;

@NoArgsConstructor
@Getter
@Setter
public class MemberRequest {
    private Long id;
    private String name;
    private String email;
    private Sex sex;
    private String phone;
    private String password;
}
