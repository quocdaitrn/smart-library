package vn.hcmut.master.smartlibrary.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import vn.hcmut.master.smartlibrary.model.User;
import vn.hcmut.master.smartlibrary.model.type.RoleName;
import vn.hcmut.master.smartlibrary.model.type.Sex;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setUsername(resultSet.getString("username"));
        user.setEmail(resultSet.getString("email"));
        if ("M".equals(resultSet.getString("sex"))) {
            user.setSex(Sex.MALE);
        } else {
            user.setSex(Sex.FEMALE);
        }
        user.setPhone(resultSet.getString("phone"));
        user.setPassword(resultSet.getString("password"));
        user.setRole(RoleName.valueOf(resultSet.getString("role")));
        user.setCreateAt(resultSet.getDate("created_at"));

        return user;
    }
}
