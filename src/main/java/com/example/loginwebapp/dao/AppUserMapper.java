package com.example.loginwebapp.dao;

import com.example.loginwebapp.entity.AppUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface AppUserMapper {
    @Select("SELECT * FROM user_role WHERE id = #{id}")
    public AppUser select(int id);

    @Select("SELECT * FROM user_role")
    public List<AppUser> findAll();

    @Insert("INSERT INTO user (id, user_id, role_id VALUES (#{id}, #{user_id}, #{role_id}")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    public void insertUser(AppUser user);

    public int getUserID(int id);
    public int getRoleID(int id);

}
