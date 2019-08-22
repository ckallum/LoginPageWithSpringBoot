package com.example.loginwebapp.dao;

import com.example.loginwebapp.entity.appUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE user_id = #{id}")
    appUser select(long id);

    @Select("SELECT * FROM user")
    List<appUser> findAll();

    @Insert("INSERT INTO user (user_id, user_name, encrypted_password VALUES (#{id}, #{username}, #{password}")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertUser(appUser user);
}
