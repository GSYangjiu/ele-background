package com.yangmiemie.ele.common.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sun.tools.internal.ws.wsdl.parser.Constants;
import com.yangmiemie.ele.common.service.ICommonService;
import com.yangmiemie.ele.common.utils.HttpRequestUtil;
import com.yangmiemie.ele.common.utils.Message;
import com.yangmiemie.ele.common.utils.MessageType;
import com.yangmiemie.ele.common.utils.UniqId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-05-11 15:39
 * Description:
 */
@Service("commonService")
public class CommonServiceImpl implements ICommonService {

    private final static Logger LOGGER = LoggerFactory.getLogger(CommonServiceImpl.class);

    @Override
    public Message getCityByIP(String ip) {
        Message msg;
        String url = "http://int.dpool.sina.com.cn/iplookup/iplookup.php";
        //String paraStr = "format=json&ip=" + ip;
        String paraStr = "format=json&ip=61.183.176.172";
        try {
            String result = unicodeToString(HttpRequestUtil.sendGet(url, paraStr));
            JSONObject json = JSONObject.parseObject(result);
            LOGGER.info("yang:" + unicodeToString(HttpRequestUtil.sendGet(url, paraStr)));
            msg = new Message();
            msg.setInfo(json.getString("city"));
        } catch (Exception e) {
            LOGGER.error("CommonServiceImpl getCityByIP METHOD ERROR " + e);
            msg = new Message(MessageType.M99999);
        }
        return msg;
    }

    /**
     * unicode转中文
     *
     * @param str
     * @return
     * @author yutao
     * @date 2017年1月24日上午10:33:25
     */
    public static String unicodeToString(String str) {
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(str);
        char ch;
        while (matcher.find()) {
            ch = (char) Integer.parseInt(matcher.group(2), 16);
            str = str.replace(matcher.group(1), ch + "");
        }
        return str;
    }

    @Override
    public String saveImg(MultipartFile multipartFile, String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            try {
                boolean flag = file.mkdirs();
                if (!flag) {
                    throw new Exception();
                }
            } catch (Exception e) {
                LOGGER.error("保存图片-创建文件夹失败");
            }
        }
        FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
        String fileName = System.currentTimeMillis() + ".png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + File.separator + fileName));
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1) {
            bos.write(bs, 0, len);
        }
        bos.flush();
        bos.close();
        return fileName;
    }
}

