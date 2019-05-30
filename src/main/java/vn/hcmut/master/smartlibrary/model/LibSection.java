package vn.hcmut.master.smartlibrary.model;

public class LibSection extends AbstractModel {
    private String name;
    private String avatar;
    private String code;
    private Integer borrowCount;
    private Boolean isPopular;
    private String description;

    public LibSection() {
    }

    public LibSection(String name, String avatar, String code, Integer borrowCount, Boolean isPopular, String description) {
        this.name = name;
        this.avatar = avatar;
        this.code = code;
        this.borrowCount = borrowCount;
        this.isPopular = isPopular;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getBorrowCount() {
        return borrowCount;
    }

    public void setBorrowCount(Integer borrowCount) {
        this.borrowCount = borrowCount;
    }

    public Boolean getPopular() {
        return isPopular;
    }

    public void setPopular(Boolean popular) {
        isPopular = popular;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
