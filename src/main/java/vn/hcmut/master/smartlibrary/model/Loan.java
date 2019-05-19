package vn.hcmut.master.smartlibrary.model;

import java.util.Date;

public class Loan {
    private User user;
    private LibItem libItem;
    private Date borrowDate;
    private String note;

    public Loan() {
    }

    public Loan(User user, LibItem libItem, Date borrowDate, String note) {
        this.user = user;
        this.libItem = libItem;
        this.borrowDate = borrowDate;
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LibItem getLibItem() {
        return libItem;
    }

    public void setLibItem(LibItem libItem) {
        this.libItem = libItem;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
