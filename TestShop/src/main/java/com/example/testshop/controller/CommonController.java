package com.example.testshop.controller;

import com.yichen.common.R;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.apache.commons.lang.mutable.MutableFloat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {

    @Value("${reggie.path}")
    private String basePath;

    @PostMapping("/upload")
    public R<String> upload(MultipartFile file){
        log.info("文件：{}",file);
        String originalFilename = file.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = UUID.randomUUID().toString() + substring;
        try {
            file.transferTo(new File(basePath+fileName));
//            file.transferTo(new File("D:\\java\\hello.ipg"));
        } catch (IOException e) {
        }
        return R.success(fileName);
    }
    @GetMapping("/download")
    public R<String> download(String name, HttpServletResponse response){
        try{
            FileInputStream fileInputStream = new FileInputStream(new File(basePath +name));
            ServletOutputStream outputStream = response.getOutputStream();
            int len=0;
            byte[] bytes=new byte[1024];
            while ((len=fileInputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
                outputStream.flush();
            }

            outputStream.close();
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.success("上传成功");
    }


}
