package vn.hcmut.master.smartlibrary.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import vn.hcmut.master.smartlibrary.model.Publisher;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PublisherRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Publisher publisher = new Publisher();
        publisher.setId(resultSet.getLong("id"));
        publisher.setName(resultSet.getString("name"));
        publisher.setAddress(resultSet.getString("address"));
        publisher.setCreateAt(resultSet.getDate("created_at"));
        publisher.setUpdateAt(resultSet.getDate("updated_at"));

        return null;
    }
}
