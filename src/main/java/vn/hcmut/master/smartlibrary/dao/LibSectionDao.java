package vn.hcmut.master.smartlibrary.dao;

import vn.hcmut.master.smartlibrary.model.LibSection;

import java.util.List;

public interface LibSectionDao extends BasicDao<LibSection> {
    List<LibSection> getPopulars();
}
