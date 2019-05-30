package vn.hcmut.master.smartlibrary.model;

import java.util.Date;

public class Loan extends AbstractModel{
    private User user;
    private LibItem libItem;
    private Date borrowDate;
    private Date dueDate;
    private Date returnDate;
    private String note;

    public Loan() {
    }

    public Loan(User user, LibItem libItem, Date borrowDate, Date dueDate, Date returnDate, String note) {
        this.user = user;
        this.libItem = libItem;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
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

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
