package vn.hcmut.master.smartlibrary.dao;

import vn.hcmut.master.smartlibrary.model.LibItem;

import java.util.List;

public interface LibItemDao extends BasicDao<LibItem> {
    List<LibItem> search(String key, Long sectionId);

    int countItems(Long sectionId);

    List<LibItem> findBySectionId(Long sectionId);
}
