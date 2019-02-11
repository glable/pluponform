package com.mota.controller;

import com.mota.service.SdkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/upload")
@CrossOrigin
public class UploadController {

    @Autowired
    SdkService sdkService;

    @RequestMapping("/singlefile")
    public Object singleFileUpload(MultipartFile file) {
        if (null == file || file.isEmpty()) {
            return "文件为空，请重新上传";
        }
        try {
            String fileName = file.getOriginalFilename();
            byte[] bytes = file.getBytes();
            sdkService.mediaFileUpload(fileName, bytes);
            return "文件上传成功";
        } catch (IOException e) {
            e.printStackTrace();
            return "后端异常...";
        }
    }
}
