package com.example.loginwebapp.mapper;

import com.example.loginwebapp.entity.appUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class appUserMapper implements RowMapper<appUser> {

    public static final String sqlbase = "SELECT u.user_id, u.user_name, u.encrypted_password FROM user u ";

    @Override
    public appUser mapRow(ResultSet resultSet, int i) throws SQLException {
        Long userID = resultSet.getLong("user_id");
        String userName = resultSet.getString("user_name");
        String password = resultSet.getString("encrypted_password");
        return new appUser(userID,userName,password);
    }
}
