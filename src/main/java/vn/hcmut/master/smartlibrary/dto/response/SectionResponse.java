package vn.hcmut.master.smartlibrary.dto.response;

import lombok.Getter;
import lombok.Setter;
import vn.hcmut.master.smartlibrary.model.LibItem;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class SectionResponse {
    private Long id;
    private String name;
    private String avatar;
    private String code;
    private String description;
    private int itemsCount;
    private Date createdAt;
    private Date updatedAt;
    private List<LibItem> items;
}
