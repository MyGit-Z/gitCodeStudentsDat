package com.example.studentsdat2.bean;

import lombok.Data;

import java.util.Date;

/**
 * 评论数据实体类
 */
@Data
public class Comment {

    /**
     * 评论id
     */
    private Integer commentId;

    /**
     * 贴吧id
     */
    private Integer articleId;

    /**
     * 学生id
     */
    private Integer id;

    /**
     * 学生用户名
     */
    private String studentName;

    /**
     * 用户头像
     */
    private String headImg;

    /**
     * 评论内容
     */
    private String commentOnContent;

    /**
     * 评论图片
     */
    private String imgComment;

    /**
     * 评论时间
     */
    private Date commentDate;


}
