package vn.hcmut.master.smartlibrary.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import vn.hcmut.master.smartlibrary.model.LibSection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LibSectionRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        LibSection libSection = new LibSection();
        libSection.setId(resultSet.getLong("id"));
        libSection.setName(resultSet.getString("name"));
        libSection.setAvatar(resultSet.getString("avatar"));
        libSection.setCode(resultSet.getString("code"));
        libSection.setDescription(resultSet.getString("description"));
        libSection.setCreateAt(resultSet.getDate("created_at"));
        libSection.setUpdateAt(resultSet.getDate("updated_at"));

        return libSection;
    }
}