package vn.hcmut.master.smartlibrary.dto.request;

import lombok.Getter;
import lombok.Setter;
import vn.hcmut.master.smartlibrary.type.RoleName;
import vn.hcmut.master.smartlibrary.type.Sex;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SignUpRequest {
    @NotBlank
    @Size(min = 2, max = 50)
    private String name;

    @NotBlank
    @Size(min = 3, max = 50)
    private String username;

    @NotBlank
    @Size(max = 100)
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;

    @NotNull
    private Sex sex;

    private String phone;

    @NotNull
    private RoleName role;
}
