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
    AppUser select(long id);

    @Select("SELECT * FROM role")
    List<AppUser> findAll();

    @Insert("INSERT INTO role (role_id, role_name VALUES (#{id}, #{role_name}")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertRole(Role role);

    public int getRoleName(int id);
    public List<Role> findRoles();

}
