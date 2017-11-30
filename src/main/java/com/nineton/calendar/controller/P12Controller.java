package com.nineton.calendar.controller;


import com.nineton.calendar.pojo.P12;
import com.nineton.calendar.pojo.PageResult;
import com.nineton.calendar.pojo.Result;
import com.nineton.calendar.service.P12Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class P12Controller {
    @Autowired
    private P12Service p12Service;

    @RequestMapping("/p12/p12Page")
    @ResponseBody
    public PageResult getP12List(Integer page, Integer limit) {

        return p12Service.getAllP12(page, limit);
    }

    @RequestMapping("/p12/list")
    @ResponseBody
    public List<P12> getP12List(){
       return p12Service.getP12List();
    }

    @RequestMapping("/p12/add")
    public String uploadP12(P12 p12, MultipartFile uploadFile) throws IOException {

        String p12File_name = uploadFile.getOriginalFilename();
        String newFileName = UUID.randomUUID().toString() + p12File_name.substring(p12File_name.lastIndexOf("."));
        //System.out.println(p12File_name);
        //System.out.println(newFileName);
        P12 p = p12Service.findByPackageName(p12.getPackageName());
        if(p!=null){
            p12Service.deleteP12(p.getId());
        }
        p12.setCreateTime(new Date());
        p12.setFileName(newFileName);
        p12Service.insert(p12);
        //向磁盘写文件
        File upload = new java.io.File("P12/");
        if (!upload.exists()) {
            upload.mkdirs();
        }
        File uploadPic = new java.io.File("P12/" + newFileName);
        if(!uploadPic.exists()){
            uploadPic.createNewFile();
        }
        byte[] bytes = uploadFile.getBytes();
        BufferedOutputStream buffStream =
                new BufferedOutputStream(new FileOutputStream(uploadPic));
        buffStream.write(bytes);
        buffStream.close();

        return "redirect:/p12-list";

    }

    @RequestMapping("/p12/delete/{id}")
    @ResponseBody
    public Result deleteP12(@PathVariable Integer id){
        p12Service.deleteP12(id);
        return Result.ok();
    }
}
