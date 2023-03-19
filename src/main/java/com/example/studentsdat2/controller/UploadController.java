package com.example.studentsdat2.controller;

import com.example.studentsdat2.utils.UploadUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * 上传照片工具类
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

    /**
     * 上传
     */
    @RequestMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam(value = "file") MultipartFile file) throws Exception {
        String path = "D:/userPic/";
        String imgUrl = "";
        // 调用图片上传工具类
        try {
            imgUrl = UploadUtils.upload(file, path);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if (imgUrl.equals("file_empty")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        if (imgUrl.equals("文件名不可为空！")){
            return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).build();
        }
        imgUrl = "http://localhost:8080" + imgUrl.substring(3);
        return ResponseEntity.status(HttpStatus.OK).body(imgUrl);
    }


}
