package com.example.loginwebapp.dao;

import com.example.loginwebapp.mapper.appUserMapper;
import com.example.loginwebapp.model.appUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Repository
@Transactional
public class userDao extends JdbcDaoSupport {
    @Autowired
    public userDao(DataSource data){
        this.setDataSource(data);
    }

    public appUser findUserAccount(String username){
        String sql = "SELECT user_id, user_name, encrypted_password FROM user WHERE user_name = ?";
        Object[] params = new Object[]{username};
        appUserMapper mapper = new appUserMapper();
        try {
            return this.getJdbcTemplate().queryForObject(sql, params, mapper);
        }catch (EmptyResultDataAccessException e){
            return null;
        }

    }
}
