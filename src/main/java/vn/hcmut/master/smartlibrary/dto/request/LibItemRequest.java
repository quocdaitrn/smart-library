package vn.hcmut.master.smartlibrary.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.hcmut.master.smartlibrary.type.LibItemStatus;
import vn.hcmut.master.smartlibrary.type.LibItemType;

@NoArgsConstructor
@Getter
@Setter
public class LibItemRequest {
    private Long id;
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
    private Long categoryId;
    private Long libSectionId;
}
