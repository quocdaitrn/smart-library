package vn.hcmut.master.smartlibrary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.hcmut.master.smartlibrary.dao.LibItemDao;
import vn.hcmut.master.smartlibrary.dao.LibSectionDao;
import vn.hcmut.master.smartlibrary.dao.PublisherDao;
import vn.hcmut.master.smartlibrary.dto.request.LibItemRequest;
import vn.hcmut.master.smartlibrary.exception.ResourceNotFoundException;
import vn.hcmut.master.smartlibrary.model.LibItem;
import vn.hcmut.master.smartlibrary.model.LibSection;
import vn.hcmut.master.smartlibrary.model.Publisher;
import vn.hcmut.master.smartlibrary.service.LibItemService;
import vn.hcmut.master.smartlibrary.model.type.LibItemStatus;

import java.util.List;

@Service
public class LibItemServiceImpl implements LibItemService {

    private final LibItemDao libItemDao;

    private final PublisherDao publisherDao;

    private final LibSectionDao libSectionDao;

    @Autowired
    public LibItemServiceImpl(LibItemDao libItemDao, PublisherDao publisherDao, LibSectionDao libSectionDao) {
        this.libItemDao = libItemDao;
        this.publisherDao = publisherDao;
        this.libSectionDao = libSectionDao;
    }

    @Override
    public List<LibItem> findAll() {
        return libItemDao.findAll();
    }

    @Override
    public List<LibItem> search(String key, Long sectionId) {
        Long sid = null;
        if (sectionId != 0) {
            sid = sectionId;
        }

        return libItemDao.search(key, sid);
    }

    @Override
    public LibItem findById(Long id) {
        return libItemDao.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("LibItem", "id", id)
        );
    }

    @Override
    public LibItem add(LibItemRequest request) {
        Publisher publisher = publisherDao.findById(request.getPublisherId()).orElseThrow(
                () -> new ResourceNotFoundException("Publisher", "id", request.getPublisherId())
        );

        LibSection libSection = libSectionDao.findById(request.getLibSectionId()).orElseThrow(
                () -> new ResourceNotFoundException("LibSection", "id", request.getLibSectionId())
        );

        LibItem libItem = new LibItem();
        libItem.setLibSection(libSection);
        libItem.setPublisher(publisher);
        libItem.setCover(request.getCover());
        libItem.setTitle(request.getTitle());
        LibItemStatus status = request.getStatus() != null ? request.getStatus() : LibItemStatus.AVAILABLE;
        libItem.setStatus(status);
        libItem.setPublishDate(request.getPublishDate());
        libItem.setPublishYear(request.getPublishYear());
        libItem.setPrice(request.getPrice());
        libItem.setDescription(request.getDescription());
        libItem.setInventoryNumber(request.getInventoryNumber());
        libItem.setEdition(request.getEdition());
        libItem.setAuthors(request.getAuthors());
        libItem.setType(request.getType());

        return libItemDao.create(libItem);
    }
}
