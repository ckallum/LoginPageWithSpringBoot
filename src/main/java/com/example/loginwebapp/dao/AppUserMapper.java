package com.example.loginwebapp.dao;

import com.example.loginwebapp.dto.AppUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AppUserMapper {
    @Select("SELECT * FROM user_role WHERE id = #{id}")
    AppUser select(int id);

    @Select("SELECT * FROM user_role")
    List<AppUser> findAll();

    @Insert("INSERT INTO user (id, user_id, role_id VALUES (#{id}, #{user_id}, #{role_id}")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertUser(AppUser user);

}
