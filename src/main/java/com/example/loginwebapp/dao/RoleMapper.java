package com.example.loginwebapp.dao;

import com.example.loginwebapp.entity.AppUser;
import com.example.loginwebapp.entity.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface RoleMapper {
    @Select("SELECT * FROM role WHERE role_id = #{id}")
    Role select(int id);

    @Select("SELECT * FROM role")
    List<Role> findAll();

    @Select("SELECT * FROM role WHERE role.name = #{name}")
    Role selectByName(String name);

    @Insert("INSERT INTO role (role_name) VALUES (#{role_name})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertRole(Role role);


}
