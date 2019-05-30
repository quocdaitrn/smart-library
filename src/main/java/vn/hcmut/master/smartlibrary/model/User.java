package vn.hcmut.master.smartlibrary.model;

import vn.hcmut.master.smartlibrary.model.type.RoleName;
import vn.hcmut.master.smartlibrary.model.type.Sex;

public class User extends AbstractModel {
    private String name;
    private String username;
    private String email;
    private Sex sex;
    private String phone;
    private String password;
    private RoleName role;

    public User() {
    }

    public User(String name, String username, String email, Sex sex, String phone, String password, RoleName role) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.sex = sex;
        this.phone = phone;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleName getRole() {
        return role;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }
}
