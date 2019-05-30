package vn.hcmut.master.smartlibrary.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.hcmut.master.smartlibrary.model.type.LibItemStatus;
import vn.hcmut.master.smartlibrary.model.type.LibItemType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
public class LibItemRequest {
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String cover;
    @NotNull
    private LibItemType type;
    private String authors;
    private String edition;
    private String inventoryNumber;
    private String description;
    @NotNull
    private Long publisherId;
    private Integer price;
    private Integer publishYear;
    private String publishDate;
    private LibItemStatus status;
    @NotNull
    private Long libSectionId;
}
