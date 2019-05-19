package vn.hcmut.master.smartlibrary.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.hcmut.master.smartlibrary.dto.request.LibItemRequest;
import vn.hcmut.master.smartlibrary.model.LibItem;
import vn.hcmut.master.smartlibrary.service.LibItemService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/items")
public class LibItemController {

    @Autowired
    private LibItemService libItemService;

    public List<LibItem> list(@Valid @RequestBody LibItemRequest request) {
        return new ArrayList<>();
    }
}
