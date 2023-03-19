package com.example.studentsdat2.mapper;

import com.example.studentsdat2.bean.StudentUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * 学生注册信息mapper
 */
@Mapper
public interface StudentUserMapper {
    Integer checkRepeat(@Param("account") String account);

    void insertStu(@Param("user") StudentUser user);

    String findQuestion(@Param("account") String account, @Param("phone") String phone);

    Integer retrievePasswordT(@Param("answer") String answer,@Param("account") String account);

    void setPassword(@Param("account") String account,@Param("password") String password);

    StudentUser login(@Param("account") String account,@Param("password") String password);

    Integer findUser(@Param("account") String account);

    StudentUser findStu(@Param("id") Integer id);

    void updateUser(@Param("user") StudentUser user);

    StudentUser showUer(@Param("id") Integer id);
}
