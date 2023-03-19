package com.example.studentsdat2.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public class UploadUtils {

    //图片上传，支持多张图片 imgUpload
    public static String upload(MultipartFile file, String path) throws IOException {
        String imgUrl = "";
        if (file.isEmpty()) {
            return "file_empty";
        }
        String filename = file.getOriginalFilename();
        if (filename.isEmpty()) {
            return "文件名不可为空！";
        }
        String type = filename.contains(".") ? filename.substring(filename.lastIndexOf(".")) : null;
        //以uid重新命名避免重复
        //拼接文件路径，方便前端接收
        String filepath = path + UUID.randomUUID() + type;
        File filesPath = new File(path);
        if (!filesPath.exists()) {
            filesPath.mkdir();
        }
        BufferedOutputStream out = null;
        try {
            //输入图片字节流
            out = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
            out.write(file.getBytes());
            imgUrl = "/" + filepath;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }

        return imgUrl;
    }

}
