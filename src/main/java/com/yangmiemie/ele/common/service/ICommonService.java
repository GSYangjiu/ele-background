package com.yangmiemie.ele.common.service;

import com.yangmiemie.ele.common.utils.Message;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-05-11 15:38
 * Description:
 */

public interface ICommonService {
    public Message getCityByIP(String ip);

    /**
     * 保存上传图片
     *
     * @param multipartFile
     * @param path
     * @return
     * @throws IOException
     */
    public String saveImg(MultipartFile multipartFile, String path) throws IOException;
}
