package com.yangmiemie.ele.common.controller;

import com.yangmiemie.ele.common.service.ICommonService;
import com.yangmiemie.ele.common.utils.Message;
import com.yangmiemie.ele.common.utils.MessageType;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-05-11 15:35
 * Description:
 */
@RequestMapping("/common")
@RestController
public class CommonController {

    @Autowired
    private ICommonService commonService;

    @Value("${file.imgPath}")
    private String imgPath;

    private final static Logger LOGGER = LoggerFactory.getLogger(CommonController.class);

    @GetMapping("/cities")
    public Message cityGuess(HttpServletRequest request) {
        String ip = null;

        //X-Forwarded-For：Squid 服务代理
        String ipAddresses = request.getHeader("X-Forwarded-For");
        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //Proxy-Client-IP：apache 服务代理
            ipAddresses = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //WL-Proxy-Client-IP：weblogic 服务代理
            ipAddresses = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //HTTP_CLIENT_IP：有些代理服务器
            ipAddresses = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //X-Real-IP：nginx服务代理
            ipAddresses = request.getHeader("X-Real-IP");
        }

        //有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
        if (ipAddresses != null && ipAddresses.length() != 0) {
            ip = ipAddresses.split(",")[0];
        }

        //还是不能获取到，最后再通过request.getRemoteAddr();获取
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            ip = request.getRemoteAddr();
        }
        return commonService.getCityByIP(ip);
    }

    @PostMapping("/addImg/{type}")
    public Message uploadImg(@RequestParam("file") MultipartFile multipartFile, @PathVariable String type) {
        if (multipartFile.isEmpty() || StringUtils.isBlank(multipartFile.getOriginalFilename())) {
            return new Message(MessageType.M11001);
        }
        String contentType = multipartFile.getContentType();
        if (!contentType.contains("")) {
            return new Message(MessageType.M11002);
        }
        String root_fileName = multipartFile.getOriginalFilename();
        LOGGER.info("上传图片:name={},type={}", root_fileName, type);

        //获取文件储存路径
        String filePath = imgPath + File.separator + type;
        LOGGER.info("图片保存路径={}", filePath);
        String fileName = null;
        try {
            Message msg;
            fileName = commonService.saveImg(multipartFile, filePath);
            if (StringUtils.isNotBlank(fileName)) {
                msg = new Message();
                msg.setInfo("img" + File.separator + type + File.separator + fileName);
            } else {
                msg = new Message(MessageType.M11003);
            }
            return msg;
        } catch (IOException e) {
            LOGGER.error("CommonController uploadImg METHOD ERROR " + e);
            return new Message(MessageType.M11003);
        }
    }
}
