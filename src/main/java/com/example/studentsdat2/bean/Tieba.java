package com.example.studentsdat2.bean;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 贴吧实体类
 */
@Data
public class Tieba {

    /**
     * 文章id
     */
    private Integer articleId;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章内容
     */
    private String articleContent;

    /**
     * 文章图片
     */
    private List<String> imgList;

    private String img;


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
     * 评论数量 默认为0
     */
    private Integer commentNumber = 0;

    /**
     * 点赞数量 默认为0
     */
    private Integer thumbUpNumber = 0;

    /**
     * 创建时间
     */
    private Date creatTime;
}
