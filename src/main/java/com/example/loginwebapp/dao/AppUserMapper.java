package com.example.loginwebapp.dao;

import com.example.loginwebapp.entity.AppUser;
import com.example.loginwebapp.entity.Role;
import com.example.loginwebapp.entity.User;
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

    @Insert("INSERT INTO user_role (user_id, role_id) VALUES (#{user_id}, #{role_id})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    public void insertUser(AppUser user);

    @Select("SELECT * FROM user INNER JOIN user_role ON user.user_id = user_role.user_id WHERE user_role.id = #{id}")
    public User getUser(int id);
    @Select("SELECT * FROM role INNER JOIN user_role ON role.role_id = user_role.role_id WHERE user_role.id = #{id}")
    public Role getRole(int id);

}
