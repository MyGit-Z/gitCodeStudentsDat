package com.example.studentsdat2.service;

import com.example.studentsdat2.bean.StudentUser;
import org.springframework.http.ResponseEntity;

public interface CreatService {
    ResponseEntity<String> register(StudentUser user);

    ResponseEntity<String> retrievePassword(String account, String phone);

    ResponseEntity<String> retrievePasswordT(String answer, String account);

    ResponseEntity<String> setPassword(String account, String password);

    ResponseEntity<StudentUser> login(String account, String password);

    ResponseEntity<String> updateUser(StudentUser user);

    ResponseEntity<StudentUser> showUer(Integer id);
}
