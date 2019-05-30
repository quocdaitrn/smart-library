package vn.hcmut.master.smartlibrary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.hcmut.master.smartlibrary.dao.LibItemDao;
import vn.hcmut.master.smartlibrary.dao.LibSectionDao;
import vn.hcmut.master.smartlibrary.dto.response.SectionResponse;
import vn.hcmut.master.smartlibrary.exception.ResourceNotFoundException;
import vn.hcmut.master.smartlibrary.model.LibSection;
import vn.hcmut.master.smartlibrary.service.LibSectionService;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibSectionServiceImpl implements LibSectionService {

    private final LibSectionDao libSectionDao;

    private final LibItemDao libItemDao;

    @Autowired
    public LibSectionServiceImpl(LibSectionDao libSectionDao, LibItemDao libItemDao) {
        this.libSectionDao = libSectionDao;
        this.libItemDao = libItemDao;
    }

    @Override
    public List<LibSection> findAll() {
        return libSectionDao.findAll();
    }

    @Override
    public List<SectionResponse> getPopularSections() {
        List<SectionResponse> sectionResponses = new ArrayList<>();
        List<LibSection> libSections = libSectionDao.getPopulars();
        for (LibSection s : libSections) {
            sectionResponses.add(mapToSectionResponse(s));
        }

        return sectionResponses;
    }

    @Override
    public SectionResponse findById(Long id) {
        LibSection libSection = libSectionDao.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("LibSection", "id", id)
        );

        return mapToSectionResponse(libSection);
    }

    private SectionResponse mapToSectionResponse(LibSection libSection) {
        SectionResponse sectionResponse = new SectionResponse();
        sectionResponse.setId(libSection.getId());
        sectionResponse.setName(libSection.getName());
        sectionResponse.setAvatar(libSection.getAvatar());
        sectionResponse.setCode(libSection.getCode());
        sectionResponse.setDescription(libSection.getDescription());
        sectionResponse.setItemsCount(libItemDao.countItems(libSection.getId()));
        sectionResponse.setCreatedAt(libSection.getCreateAt());
        sectionResponse.setUpdatedAt(libSection.getUpdateAt());
        sectionResponse.setItems(libItemDao.findBySectionId(libSection.getId()));

        return sectionResponse;
    }
}
