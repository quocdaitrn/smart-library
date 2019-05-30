package vn.hcmut.master.smartlibrary.dao.mapper;

import vn.hcmut.master.smartlibrary.model.LibItem;
import vn.hcmut.master.smartlibrary.type.LibItemStatus;
import vn.hcmut.master.smartlibrary.type.LibItemType;

import java.util.Date;
import java.util.Map;

public class LibItemMapper {
    public static LibItem map(Map<String, Object> row) {
        LibItem libItem = new LibItem();
        libItem.setId((Long) row.get("id"));
        libItem.setTitle((String) row.get("title"));
        libItem.setCover((String) row.get("cover"));
        libItem.setType(LibItemType.valueOf((String) row.get("type")));
        libItem.setAuthors((String) row.get("authors"));
        libItem.setEdition((String) row.get("edition"));
        libItem.setInventoryNumber((String) row.get("inventory_number"));
        libItem.setDescription((String) row.get("description"));
        libItem.setPrice((Integer) row.get("price"));
        libItem.setPublishYear((Integer) row.get("publish_year"));
        libItem.setPublishDate((String) row.get("publish_date"));
        libItem.setStatus(LibItemStatus.valueOf((String) row.get("status")));
        libItem.setCreateAt((Date) row.get("created_at"));
        libItem.setUpdateAt((Date) row.get("updated_at"));

        return libItem;
    }
}
