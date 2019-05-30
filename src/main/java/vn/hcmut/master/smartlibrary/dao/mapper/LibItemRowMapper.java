package vn.hcmut.master.smartlibrary.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import vn.hcmut.master.smartlibrary.model.LibItem;
import vn.hcmut.master.smartlibrary.model.LibSection;
import vn.hcmut.master.smartlibrary.model.Publisher;
import vn.hcmut.master.smartlibrary.model.type.LibItemStatus;
import vn.hcmut.master.smartlibrary.model.type.LibItemType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LibItemRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        LibItem libItem = new LibItem();
        libItem.setId(resultSet.getLong("id"));
        libItem.setTitle(resultSet.getString("title"));
        libItem.setCover(resultSet.getString("cover"));
        libItem.setType(LibItemType.valueOf(resultSet.getString("type")));
        libItem.setAuthors(resultSet.getString("authors"));
        libItem.setEdition(resultSet.getString("edition"));
        libItem.setInventoryNumber(resultSet.getString("inventory_number"));
        libItem.setDescription(resultSet.getString("description"));
        libItem.setPrice(resultSet.getInt("price"));
        libItem.setPublishYear(resultSet.getInt("publish_year"));
        libItem.setPublishDate(resultSet.getString("publish_date"));
        libItem.setStatus(LibItemStatus.valueOf(resultSet.getString("status")));
        libItem.setCreateAt(resultSet.getDate("created_at"));
        libItem.setUpdateAt(resultSet.getDate("updated_at"));

        // set publisher
        Publisher publisher = new Publisher();
        publisher.setId(resultSet.getLong("publisher_id"));
        publisher.setName(resultSet.getString("publisher_name"));
        libItem.setPublisher(publisher);

        // set lib section
        LibSection libSection = new LibSection();
        libSection.setId(resultSet.getLong("section_id"));
        libSection.setName(resultSet.getString("section_name"));
        libItem.setLibSection(libSection);

        return libItem;
    }
}