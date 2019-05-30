package vn.hcmut.master.smartlibrary.dao.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import vn.hcmut.master.smartlibrary.dao.LibItemDao;
import vn.hcmut.master.smartlibrary.dao.mapper.LibItemMapper;
import vn.hcmut.master.smartlibrary.dao.mapper.LibItemRowMapper;
import vn.hcmut.master.smartlibrary.model.LibItem;
import vn.hcmut.master.smartlibrary.model.LibSection;
import vn.hcmut.master.smartlibrary.model.Publisher;
import vn.hcmut.master.smartlibrary.type.LibItemStatus;
import vn.hcmut.master.smartlibrary.type.LibItemType;

import java.util.*;

@Component
public class LibItemDaoImpl implements LibItemDao {

    private Logger logger = LoggerFactory.getLogger(LibItemDaoImpl.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LibItemDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<LibItem> findAll() {
        final String sql = "SELECT li.*, ls.id AS section_id, ls.name AS section_name, p.id AS publisher_id, p.name AS publisher_name " +
               "FROM lib_items AS li " +
               "JOIN lib_sections AS ls ON li.lib_section_id = ls.id " +
               "JOIN publishers AS p ON li.publisher_id = p.id";

        logger.debug(sql);

        final List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        return mappingResultToList(rows);
    }

    @Override
    public Optional<LibItem> findById(Long id) {
        final String sql = "SELECT li.*, ls.id AS section_id, ls.name AS section_name, p.id AS publisher_id, p.name AS publisher_name " +
                "FROM lib_items AS li " +
                "JOIN lib_sections AS ls ON li.lib_section_id = ls.id " +
                "JOIN publishers AS p ON li.publisher_id = p.id " +
                "WHERE li.id = ? LIMIT 1";

        logger.debug(sql);

        LibItem libItem;
        try {
            libItem = (LibItem) jdbcTemplate.queryForObject(
                    sql, new Object[] { id }, new LibItemRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }

        return Optional.ofNullable(libItem);
    }

    @Override
    public LibItem create(LibItem obj) {
        return null;
    }

    @Override
    public LibItem update(LibItem obj) {
        return null;
    }

    @Override
    public void delete(LibItem obj) {

    }

    @Override
    public List<LibItem> search(String key, Long sectionId) {
        String sql = "SELECT li.*, ls.id AS section_id, ls.name AS section_name, p.id AS publisher_id, p.name AS publisher_name " +
                "FROM lib_items AS li " +
                "JOIN lib_sections AS ls ON li.lib_section_id = ls.id " +
                "JOIN publishers AS p ON li.publisher_id = p.id ";

        List<String> conditions = new ArrayList<>();
        if (sectionId != null) {
            conditions.add("li.lib_section_id = " + sectionId);
        }
        if (!StringUtils.isEmpty(key)) {
            conditions.add("li.title LIKE '%" + key + "%' " +
                    "OR li.authors LIKE '%" + key + "%' " +
                    "OR li.description LIKE '%" + key + "%' ");
        }

        String strConditions = String.join(" AND ", conditions);
        if (StringUtils.isNoneEmpty(strConditions)) {
            sql += "WHERE " + strConditions;
        }

        logger.debug(sql);

        final List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        return mappingResultToList(rows);
    }

    @Override
    public int countItems(Long sectionId) {
        String sql = "SELECT count(*) FROM lib_items WHERE id = ?";

        return jdbcTemplate.queryForObject(
                sql, new Object[] { sectionId }, Integer.class);
    }

    @Override
    public List<LibItem> findBySectionId(Long sectionId) {
        final String sql = "SELECT li.*, ls.id AS section_id, ls.name AS section_name, p.id AS publisher_id, p.name AS publisher_name " +
                "FROM lib_items AS li " +
                "JOIN lib_sections AS ls ON li.lib_section_id = ls.id " +
                "JOIN publishers AS p ON li.publisher_id = p.id " +
                "WHERE li.lib_section_id = ? LIMIT 1";

        logger.debug(sql);

        final List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, sectionId);

        return mappingResultToList(rows);
    }

    private List<LibItem> mappingResultToList(List<Map<String, Object>> rows) {
        List<LibItem> libItems = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            LibItem libItem = LibItemMapper.map(row);

            // set publisher
            Publisher publisher = new Publisher();
            publisher.setId((Long) row.get("publisher_id"));
            publisher.setName((String) row.get("publisher_name"));
            libItem.setPublisher(publisher);

            // set lib section
            LibSection libSection = new LibSection();
            libSection.setId((Long) row.get("section_id"));
            libSection.setName((String) row.get("section_name"));
            libItem.setLibSection(libSection);

            libItems.add(libItem);
        }

        return libItems;
    }
}
