package com.example.studentsdat2.mapper;

import com.example.studentsdat2.bean.Comment;
import com.example.studentsdat2.bean.Tieba;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 贴吧数据mapper
 */
@Mapper
public interface TiebaMapper {
    void insertTieba(@Param("tieba") Tieba tieba);

    List<Tieba> showTieba();

    void thumbUp(@Param("articleId") Integer articleId);

    void creatComment(@Param("comment") Comment comment);

    void addCommentNumber(@Param("articleId") Integer articleId);

    List<Comment> showComment(@Param("articleId") Integer articleId);

    void delTieba(@Param("articleId") Integer articleId);

    Integer findTieba(@Param("commentId") Integer commentId);

    void delComment(@Param("commentId") Integer commentId);

    Tieba findTiebaData(@Param("articleId") Integer articleId);

    void subCommentNumber(@Param("articleId") Integer articleId);
}
