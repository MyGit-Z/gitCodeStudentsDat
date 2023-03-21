package com.example.studentsdat2.controller;


import com.example.studentsdat2.bean.Comment;
import com.example.studentsdat2.bean.Tieba;
import com.example.studentsdat2.service.CreatService;
import com.example.studentsdat2.service.TiebaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/tieba")
public class TiebaController {

    @Resource
    private TiebaService tiebaService;

    //新加入的代码       是a
    @Resource
    private CreatService creatService;

    /**
     * 创建贴吧
     */
    @RequestMapping("/creatTie")
    public ResponseEntity<String> creatTie(@RequestBody Tieba tieba) {
        return tiebaService.creatTie(tieba);
    }

    /**
     * 显示贴吧
     */
    @RequestMapping("/showTieba")
    public ResponseEntity<List<Tieba>> showTieba() {
        return tiebaService.showTieba();
    }

    /**
     * 贴吧点赞
     */
    @RequestMapping("/thumbUp")
    public ResponseEntity<String> thumbUp(Integer articleId) {
        return tiebaService.thumbUp(articleId);
    }

    /**
     * 贴吧评论
     */
    @RequestMapping("/creatComment")
    public ResponseEntity<String> creatComment(@RequestBody Comment comment) {
        return tiebaService.creatComment(comment);
    }

    /**
     * 评论回显
     */
    @RequestMapping("/showComment")
    public ResponseEntity<List<Comment>> showComment(Integer articleId) {
        return tiebaService.showComment(articleId);
    }

    /**
     * 贴吧删除
     */
    @RequestMapping("/delTieba")
    public ResponseEntity<String> delTieba(Integer articleId) {
        return tiebaService.delTieba(articleId);
    }

    /**
     * 评论删除
     */
    @RequestMapping("/delComment")
    public ResponseEntity<String> delComment(Integer commentId) {
        return tiebaService.delComment(commentId);
    }
}
