package vn.hcmut.master.smartlibrary.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vn.hcmut.master.smartlibrary.dto.request.LibItemRequest;
import vn.hcmut.master.smartlibrary.dto.response.ApiResponse;
import vn.hcmut.master.smartlibrary.model.LibItem;
import vn.hcmut.master.smartlibrary.web.security.CurrentUser;
import vn.hcmut.master.smartlibrary.web.security.UserPrincipal;
import vn.hcmut.master.smartlibrary.service.LibItemService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/items")
public class LibItemController {

    private final LibItemService libItemService;

    @Autowired
    public LibItemController(LibItemService libItemService) {
        this.libItemService = libItemService;
    }

    @GetMapping
    public List<LibItem> all() {
        return libItemService.findAll();
    }

    @GetMapping("/search")
    public List<LibItem> search(@RequestParam("keyword") String key, @RequestParam("sid") Long sectionId) {
        return libItemService.search(key, sectionId);
    }

    @GetMapping("/{id}")
    public LibItem findById(@PathVariable("id") Long id) {
        return libItemService.findById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> add(@Valid @RequestBody LibItemRequest request, @CurrentUser UserPrincipal currentUser) {
        libItemService.add(request);

        return ResponseEntity.status(201)
                .body(new ApiResponse(true, "Item added successfully"));
    }
}
