package vn.hcmut.master.smartlibrary.service;

import vn.hcmut.master.smartlibrary.dto.response.SectionResponse;
import vn.hcmut.master.smartlibrary.model.LibSection;

import java.util.List;

public interface LibSectionService {
    List<LibSection> findAll();

    List<SectionResponse> getPopularSections();

    SectionResponse findById(Long id);
}
