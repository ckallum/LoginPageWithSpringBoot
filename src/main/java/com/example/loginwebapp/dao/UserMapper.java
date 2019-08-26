package com.example.loginwebapp.dao;

import com.example.loginwebapp.entity.AppUser;
import org.apache.ibatis.annotations.*;
import com.example.loginwebapp.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE user_id = #{id}")
    User select(int id);

    User selectByName(String username);


    @Select("SELECT * FROM user")
    List<User> findAll();

    @Insert("INSERT INTO user (user_id, user_name, encrypted_password) VALUES (#{id}, #{username}, #{password})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertUser(User user);

    public String getUsername(int id);
    public String getPassword(int id);
    int setUser(User info);

}
