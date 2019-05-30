package vn.hcmut.master.smartlibrary.dto.response;

import lombok.Getter;
import lombok.Setter;
import vn.hcmut.master.smartlibrary.model.type.LibItemStatus;
import vn.hcmut.master.smartlibrary.model.type.LibItemType;

@Getter
@Setter
public class ItemResponse {
    private Long id;
    private String title;
    private String cover;
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
}
