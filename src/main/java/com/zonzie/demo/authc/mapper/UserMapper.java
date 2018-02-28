package com.zonzie.demo.authc.mapper;

import com.zonzie.demo.authc.dto.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by zonzie on 2018/2/26.
 */
@Mapper
public interface UserMapper {
    @Select("select * from user where uid = #{userId}")
    User findByUsername(int userId);

    @Update("UPDATE user SET password = #{password} WHERE uid = 1")
    void updateUser(String password);
}