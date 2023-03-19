package com.example.studentsdat2.service;

import com.example.studentsdat2.bean.Comment;
import com.example.studentsdat2.bean.StudentUser;
import com.example.studentsdat2.bean.Tieba;
import com.example.studentsdat2.mapper.StudentUserMapper;
import com.example.studentsdat2.mapper.TiebaMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class TiebaServiceImpl implements TiebaService {

    @Resource
    private TiebaMapper tiebaMapper;

    @Resource
    private StudentUserMapper studentUserMapper;

    @Override
    public ResponseEntity<String> creatTie(Tieba tieba) {
        StudentUser studentUser = studentUserMapper.findStu(tieba.getId());
        List<String> imgList = tieba.getImgList();
        String img = StringUtils.join(imgList, ",");
        tieba.setImg(img);
        tieba.setCommentNumber(0);
        tieba.setThumbUpNumber(0);
        tieba.setStudentName(studentUser.getStudentName());
        tieba.setHeadImg(studentUser.getHeadImg());
        tiebaMapper.insertTieba(tieba);
        return ResponseEntity.status(HttpStatus.OK).body("发表成功！");
    }

    @Override
    public ResponseEntity<List<Tieba>> showTieba() {
        List<Tieba> tiebas = tiebaMapper.showTieba();
        for (Tieba tieba : tiebas) {
            String img = tieba.getImg();
            if (StringUtils.isNotEmpty(img)) {
                tieba.setImgList(Arrays.asList(img.split(",")));
            }
        }
        return ResponseEntity.ok(tiebas);
    }

    @Override
    public ResponseEntity<String> thumbUp(Integer articleId) {
        tiebaMapper.thumbUp(articleId);
        return ResponseEntity.ok("点赞成功！");
    }

    @Override
    public ResponseEntity<String> creatComment(Comment comment) {
        StudentUser studentUser = studentUserMapper.findStu(comment.getId());
        comment.setStudentName(studentUser.getStudentName());
        comment.setHeadImg(studentUser.getHeadImg());
        //填入评论
        tiebaMapper.creatComment(comment);
        //贴吧表 评论数量+1
        tiebaMapper.addCommentNumber(comment.getArticleId());
        return ResponseEntity.ok("评论成功！");
    }

    @Override
    public ResponseEntity<List<Comment>> showComment(Integer articleId) {
        List<Comment> comments = tiebaMapper.showComment(articleId);
        return ResponseEntity.ok(comments);
    }

    @Override
    public ResponseEntity<String> delTieba(Integer articleId) {
        tiebaMapper.delTieba(articleId);
        return ResponseEntity.ok("删除成功");
    }

    @Override
    public ResponseEntity<String> delComment(Integer commentId) {
        //查找评论属于那个帖子
        Integer articleId = tiebaMapper.findTieba(commentId);
        //删除评论
        tiebaMapper.delComment(commentId);
        //查看帖子详情
        Tieba tieba = tiebaMapper.findTiebaData(articleId);
        if (null == tieba){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("评论删除错误！请刷新后重试！");
        }
        //查看贴吧有多少评论 如果评论数量 = 0  不进行减次数
        if (tieba.getCommentNumber() > 0) {
            //帖子评论数量-1
            tiebaMapper.subCommentNumber(articleId);
        }
        return ResponseEntity.ok("删除成功");
    }

}
