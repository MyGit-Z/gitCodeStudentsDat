package com.example.studentsdat2.bean;

import lombok.Data;

/**
 * 学生注册信息实体类
 */
@Data
public class StudentUser {

    /**
     * 学生id
     */
    private Integer id;

    /**
     * 学生账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 学生用户名
     */
    private String studentName;

    /**
     * 学生注册手机号
     */
    private String phone;

    /**
     * 用户头像
     */
    private String headImg;

    /**
     * 密保问题
     */
    private String question;

    /**
     * 密保答案
     */
    private String answer;

    /**
     * 身份证明  0普通用户  1管理员 admin 000000
     * 注册时 默认为 0
     */
    private Integer idCard = 0;

}
