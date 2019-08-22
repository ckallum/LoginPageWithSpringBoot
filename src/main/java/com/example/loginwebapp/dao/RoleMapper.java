package com.example.loginwebapp.dao;

import com.example.loginwebapp.entity.appUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper {
    @Select("SELECT * FROM role WHERE role_id = #{id}")
    appUser select(long id);

    @Select("SELECT * FROM role")
    List<appUser> findAll();

    @Insert("INSERT INTO role (role_id, role_name VALUES (#{id}, #{role_name}")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertUser(appUser user);

}