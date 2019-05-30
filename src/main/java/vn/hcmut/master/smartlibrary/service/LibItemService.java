package vn.hcmut.master.smartlibrary.service;

import vn.hcmut.master.smartlibrary.dto.request.LibItemRequest;
import vn.hcmut.master.smartlibrary.model.LibItem;

import java.util.List;

public interface LibItemService {
    List<LibItem> findAll();

    List<LibItem> search(String key, Long sectionId);

    LibItem findById(Long id);

    LibItem add(LibItemRequest request);
}
