package vn.hcmut.master.smartlibrary.model;

import vn.hcmut.master.smartlibrary.type.LibItemStatus;
import vn.hcmut.master.smartlibrary.type.LibItemType;

public class LibItem extends AbstractModel {
    private String title;
    private String cover;
    private LibItemType type;
    private String inventoryNumber;
    private String description;
    private Publisher publisher;
    private Integer price;
    private LibItemStatus status;
    private String authors;
    private String edition;
    private Integer publishYear;
    private String publishDate;
    private LibSection libSection;

    public LibItem() {
    }

    public LibItem(String title, String cover, LibItemType type, String inventoryNumber, String description, Publisher publisher, Integer price, LibItemStatus status, String authors, String edition, Integer publishYear, String publishDate, LibSection libSection) {
        this.title = title;
        this.cover = cover;
        this.type = type;
        this.inventoryNumber = inventoryNumber;
        this.description = description;
        this.publisher = publisher;
        this.price = price;
        this.status = status;
        this.authors = authors;
        this.edition = edition;
        this.publishYear = publishYear;
        this.publishDate = publishDate;
        this.libSection = libSection;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public LibItemType getType() {
        return type;
    }

    public void setType(LibItemType type) {
        this.type = type;
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

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public LibItemStatus getStatus() {
        return status;
    }

    public void setStatus(LibItemStatus status) {
        this.status = status;
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

    public LibSection getLibSection() {
        return libSection;
    }

    public void setLibSection(LibSection libSection) {
        this.libSection = libSection;
    }
}
