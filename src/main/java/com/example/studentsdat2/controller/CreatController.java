package com.example.studentsdat2.controller;


import com.example.studentsdat2.bean.StudentUser;
import com.example.studentsdat2.service.CreatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 登录 注册 工具类
 */
@RestController
@RequestMapping("/creat")
public class CreatController {

    @Resource
    private CreatService creatService;

    /**
     * 注册
     */
    @RequestMapping("/register")
    public ResponseEntity<String> register(@RequestBody StudentUser user) {
        return creatService.register(user);
    }

    /**
     * 找回密码 1  利用账号 和 注册手机号查找是否有学生
     * 存在 返回学生密保
     */
    @RequestMapping("/retrievePassword")
    public ResponseEntity<String> retrievePassword(String account, String phone) {
        return creatService.retrievePassword(account, phone);
    }

    /**
     * 找回密码2   回答密保问题 验证
     */
    @RequestMapping("/retrievePasswordT")
    public ResponseEntity<String> retrievePasswordT(String answer, String account) {
        return creatService.retrievePasswordT(answer, account);
    }

    /**
     * 找回密码3  重新设置密码
     */
    @RequestMapping("/setPassword")
    public ResponseEntity<String> setPassword(String account,String password){
        return creatService.setPassword(account, password);
    }


    /**
     * 登录
     */
    @RequestMapping("/login")
    public ResponseEntity<StudentUser> login(String account,String password){
        return creatService.login(account, password);
    }

    /**
     * 修改内容
     */
    @RequestMapping("/updateUser")
    public ResponseEntity<String> updateUser(@RequestBody StudentUser user){
        return creatService.updateUser(user);
    }

    /**
     * 修改内容回显
     */
    @RequestMapping("/showUer")
    public ResponseEntity<StudentUser> showUer(Integer id){
        return creatService.showUer(id);
    }
}
