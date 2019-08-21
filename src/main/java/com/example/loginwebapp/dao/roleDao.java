package com.example.loginwebapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional
public class roleDao extends JdbcDaoSupport {
    @Autowired
    public roleDao(DataSource source){
        this.setDataSource(source);
    }

    public List<String> getRoles (Long userID){
        String sql = "SELECT role_name " + "FROM user_role, role " + "WHERE user_role.role_id = role.role_id and user_role.user_id = ?";
        Object[] params = new Object[] {userID};
        assert this.getJdbcTemplate() != null;
        return this.getJdbcTemplate().queryForList(sql, params, String.class);
    }
}
