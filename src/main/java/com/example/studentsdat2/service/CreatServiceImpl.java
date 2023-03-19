package com.example.studentsdat2.service;

import com.example.studentsdat2.bean.StudentUser;
import com.example.studentsdat2.mapper.StudentUserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
public class CreatServiceImpl implements CreatService {

    @Resource
    private StudentUserMapper studentUserMapper;

    @Override
    public ResponseEntity<String> register(StudentUser user) {

        //查找学生账号是否重复
        Integer count = studentUserMapper.checkRepeat(user.getAccount());
        if (count > 1) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("账号重复");
        }
        studentUserMapper.insertStu(user);
        return ResponseEntity.status(HttpStatus.OK).body("注册成功");
    }

    @Override
    public ResponseEntity<String> retrievePassword(String account, String phone) {
        //查找是否有这个学生账号
        String question = studentUserMapper.findQuestion(account, phone);
        if (!StringUtils.hasText(question)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("未找到学生信息");
        }
        return ResponseEntity.status(HttpStatus.OK).body(question + "," + account);
    }

    @Override
    public ResponseEntity<String> retrievePasswordT(String answer, String account) {
        //查询密保问题是否正确
        Integer id = studentUserMapper.retrievePasswordT(answer, account);
        if (null != id) {
            return ResponseEntity.status(HttpStatus.OK).body("找回成功！");
        }
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("密保问题不正确！");
    }

    @Override
    public ResponseEntity<String> setPassword(String account, String password) {
        studentUserMapper.setPassword(account, password);
        return ResponseEntity.status(HttpStatus.OK).body("修改成功！");
    }

    @Override
    public ResponseEntity<StudentUser> login(String account, String password) {

        //判断用户是否存在
        Integer count = studentUserMapper.findUser(account);
        if (null == count || count <= 0){
            return ResponseEntity.status(HttpStatus.PROXY_AUTHENTICATION_REQUIRED).body(null);
        }
        //验证密码
        StudentUser studentUser = studentUserMapper.login(account, password);
        if (studentUser != null) {
            return ResponseEntity.status(HttpStatus.OK).body(studentUser);
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
    }

    @Override
    public ResponseEntity<String> updateUser(StudentUser user) {
        studentUserMapper.updateUser(user);
        return ResponseEntity.status(HttpStatus.OK).body("修改成功！");
    }

    @Override
    public ResponseEntity<StudentUser> showUer(Integer id) {
        StudentUser user = studentUserMapper.showUer(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
