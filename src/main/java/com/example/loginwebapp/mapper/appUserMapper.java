package com.example.loginwebapp.mapper;

import com.example.loginwebapp.model.appUser;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class appUserMapper implements RowMapper<appUser> {

    public static final String sqlbase = "SELECT user_id, user_name, encrypted_password FROM user ";

    @Override
    public appUser mapRow(ResultSet resultSet, int i) throws SQLException {
        Long userID = resultSet.getLong("user_id");
        String userName = resultSet.getString("user_name");
        String password = resultSet.getString("encrypted_password");
        return new appUser(userID,userName,password);
    }
}
