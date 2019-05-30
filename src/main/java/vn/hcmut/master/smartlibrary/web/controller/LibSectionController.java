package vn.hcmut.master.smartlibrary.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.hcmut.master.smartlibrary.dto.response.SectionResponse;
import vn.hcmut.master.smartlibrary.model.LibSection;
import vn.hcmut.master.smartlibrary.service.LibSectionService;

import java.util.List;

@RestController
@RequestMapping("/api/sections")
public class LibSectionController {

    private final LibSectionService libSectionService;

    @Autowired
    public LibSectionController(LibSectionService libSectionService) {
        this.libSectionService = libSectionService;
    }

    @GetMapping
    public List<LibSection> list() {
        return libSectionService.findAll();
    }

    @GetMapping("/popular")
    public List<SectionResponse> findPopularProvinces() {
        return libSectionService.getPopularSections();
    }

    @GetMapping("/{id}")
    public SectionResponse findById(@PathVariable("id") Long id) {
        return libSectionService.findById(id);
    }
}
