package vn.hcmut.master.smartlibrary.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import vn.hcmut.master.smartlibrary.dao.LibSectionDao;
import vn.hcmut.master.smartlibrary.dao.mapper.LibSectionRowMapper;
import vn.hcmut.master.smartlibrary.model.LibSection;

import java.util.*;

@Component
public class LibSectionDaoImpl implements LibSectionDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LibSectionDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<LibSection> findAll() {
        final String sql = "SELECT * from lib_sections";
        final List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        return mappingResultToList(rows);
    }

    @Override
    public Optional<LibSection> findById(Long id) {
        String sql = "SELECT * FROM lib_sections WHERE id = ? LIMIT 1";

        LibSection libSection;
        try {
            libSection = (LibSection) jdbcTemplate.queryForObject(
                    sql, new Object[] { id }, new LibSectionRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }

        return Optional.ofNullable(libSection);
    }

    @Override
    public LibSection create(LibSection obj) {
        return null;
    }

    @Override
    public LibSection update(LibSection obj) {
        return null;
    }

    @Override
    public void delete(LibSection obj) {

    }

    @Override
    public List<LibSection> getPopulars() {
        final String sql = "SELECT * from lib_sections WHERE is_popular = 1";
        final List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        return mappingResultToList(rows);
    }

    private List<LibSection> mappingResultToList(List<Map<String, Object>> rows) {
        List<LibSection> libSections = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            LibSection libSection = new LibSection();
            libSection.setId((Long) row.get("id"));
            libSection.setName((String) row.get("name"));
            libSection.setAvatar((String) row.get("avatar"));
            libSection.setCode((String) row.get("code"));
            libSection.setBorrowCount((Integer) row.get("borrow_count"));
            libSection.setPopular((Boolean) row.get("is_popular"));
            libSection.setDescription((String) row.get("description"));
            libSection.setCreateAt((Date) row.get("created_at"));
            libSection.setUpdateAt((Date) row.get("updated_at"));

            libSections.add(libSection);
        }

        return libSections;
    }
}
