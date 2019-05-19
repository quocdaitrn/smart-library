package vn.hcmut.master.smartlibrary.model;

import vn.hcmut.master.smartlibrary.type.LibItemStatus;
import vn.hcmut.master.smartlibrary.type.LibItemType;

public class LibItem extends AbstractModel {
    private String title;
    private LibItemType type;
    private String authors;
    private String edition;
    private String inventoryNumber;
    private String description;
    private String publisher;
    private Integer price;
    private Integer publishYear;
    private String publishDate;
    private LibItemStatus status;
    private Category category;
    private LibSection libSection;

    public LibItem() {
    }

    public LibItem(String title, LibItemType type, String authors, String edition, String inventoryNumber, String description, String publisher, Integer price, Integer publishYear, String publishDate, LibItemStatus status, Category category, LibSection libSection) {
        this.title = title;
        this.type = type;
        this.authors = authors;
        this.edition = edition;
        this.inventoryNumber = inventoryNumber;
        this.description = description;
        this.publisher = publisher;
        this.price = price;
        this.publishYear = publishYear;
        this.publishDate = publishDate;
        this.status = status;
        this.category = category;
        this.libSection = libSection;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LibItemType getType() {
        return type;
    }

    public void setType(LibItemType type) {
        this.type = type;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public LibItemStatus getStatus() {
        return status;
    }

    public void setStatus(LibItemStatus status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LibSection getLibSection() {
        return libSection;
    }

    public void setLibSection(LibSection libSection) {
        this.libSection = libSection;
    }
}
