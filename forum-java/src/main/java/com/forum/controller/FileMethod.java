package com.forum.controller;

import lombok.SneakyThrows;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Map;
import java.util.UUID;

public class FileMethod {
    /**
    *获取前端上传的文件
     */
    @SneakyThrows
    public String uploadFile(HttpServletRequest req){
        System.err.println("---将图片保存到指定位置----");
        String respFileName="";//用于返回数据
        //将获取的数据转换
        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) req;
        //获取一起和文件传来的其他参数
        String uID = req.getParameter("uID");
        System.out.println(uID);
        //获取文件
        Map<String, MultipartFile> fileMap = mRequest.getFileMap();

        //存储地址（真实路径）
        String path =req.getServletContext().getRealPath("/uploadFile/")+uID+"/";
        System.out.println(path);
        //遍历fileMap获取单个文件
        for (Map.Entry<String,MultipartFile> entry: fileMap.entrySet()) {
            //存放到MultipartFile对象方便调用
            MultipartFile file = entry.getValue();
            System.out.println("文件大小："+file.getSize());

            //获取文件原名
            String fileName = file.getOriginalFilename();
            //获取文件后缀名
		    String suffixName = fileName.substring(fileName.lastIndexOf("."));
            //使用UUID重新生成文件名
		    fileName = UUID.randomUUID()+suffixName;
             System.out.println(suffixName);
             System.out.println(fileName);

            //创建实际的保存路径
            File saveFile = new File(path + fileName);
            respFileName="/uploadFile/"+uID+"/"+fileName;//赋值返回值
            //检测文件夹是否创建 文件夹存在时exists为true
            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
            }
            //将文件存放
            file.transferTo(saveFile);
        }
        return respFileName;
    }
}