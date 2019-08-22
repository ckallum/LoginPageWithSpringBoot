package com.example.loginwebapp.dao;

import com.example.loginwebapp.entity.appUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AppUserMapper {
    @Select("SELECT * FROM user_role WHERE id = #{id}")
    appUser select(long id);

    @Select("SELECT * FROM user_role")
    List<appUser> findAll();

    @Insert("INSERT INTO user (id, user_id, role_id VALUES (#{id}, #{user_id}, #{role_id}")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertUser(appUser user);

}
