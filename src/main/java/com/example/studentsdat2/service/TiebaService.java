package com.example.studentsdat2.service;

import com.example.studentsdat2.bean.Comment;
import com.example.studentsdat2.bean.Tieba;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TiebaService {
    ResponseEntity<String> creatTie(Tieba tieba);

    ResponseEntity<List<Tieba>> showTieba();

    ResponseEntity<String> thumbUp(Integer articleId);

    ResponseEntity<String> creatComment(Comment comment);

    ResponseEntity<List<Comment>> showComment(Integer articleId);

    ResponseEntity<String> delTieba(Integer articleId);

    ResponseEntity<String> delComment(Integer commentId);
}
